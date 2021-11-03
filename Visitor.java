import java.util.Locale;
import java.util.Objects;

public class Visitor extends calcBaseVisitor<Void>{
    public String results="";
    public int Num=1;
    static Integer getnumber(String s){
        int res = 0;
        s = s.toLowerCase(Locale.ROOT);
        if (s.charAt(0)=='0'){
            if(s.length()==1){
                return 0;
            }
            if(s.charAt(1)=='x'||s.charAt(1)=='X'){
                int len = s.length();
                s = s.toLowerCase();
                for (int i=2;i<len;i++){
                    if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                        res=16*res+ (int) s.charAt(i)-48;
                    }
                    else if(s.charAt(i)>='a'&&s.charAt(i)<='f'){
                        res=16*res +10+ ((int) s.charAt(i)-'a');
                    }
                    else {
                        return res;
                    }
                }
                return res;
            }
            else {
                int len = s.length();
                for(int i=1;i<len;i++){
                    res=8*res+ (int) s.charAt(i)-48;
                }
                return res;
            }
        }
        else if(s.charAt(0)<'0'||s.charAt(0)>'9'){
            return null;
        }
        else {
            return Integer.valueOf(s);
        }
    }
    @Override public Void visitCompUnit(calcParser.CompUnitContext ctx) {
        return super.visitCompUnit(ctx);
    }
    @Override public Void visitFuncDef(calcParser.FuncDefContext ctx) {
        if(ctx.FuncType().getText().equals("int")){
            results+="define dso_local ";
        }
        if(ctx.Ident().getText().equals("main")){
            results+="i32 @main";
        }
        results+="()";
        visit(ctx.block());
        return null;
    }
    @Override public Void visitBlock(calcParser.BlockContext ctx) {
        results+="{\n";
        for(int i=0;i<ctx.blockItem().size();i++){
            visit(ctx.blockItem(i));
        }
        results+="}";
        return null;
    }
    @Override public Void visitStmt(calcParser.StmtContext ctx) {
        if(ctx.lval()!=null){
            String a=visitLval(ctx.lval());
            String s=visitExp(ctx.exp());
            VarList list=VarList.getInstance();
            list.getVar(ctx.lval().getText()).setInit(true);
            results+="store i32 "+s+", i32* "+ list.getVar(ctx.lval().getText()).getNum()+"\n";
        }
        else if(ctx.getText().startsWith("return")){
            String s=visitExp(ctx.exp());
            results+="ret i32 "+s+"\n";
        }
        else {
            if(ctx.exp()!=null){
                visit(ctx.exp());
            }
        }
        return null;
    }

    @Override
    public String visitExp(calcParser.ExpContext ctx) {
        return visitAddexp(ctx.addexp());
    }

    @Override
    public String visitAddexp(calcParser.AddexpContext ctx) {
        switch (ctx.children.size()){
            case 1:
                return visitMulexp(ctx.mulexp());
            case 3:
                String left=visitAddexp(ctx.addexp());
                String right=visitMulexp(ctx.mulexp());
                if(Objects.equals(ctx.Addfunc().getText(), "+")){
                    results+="%"+Num+" = add i32 "+left+","+right+"\n";
//                    System.out.println("%"+Num+" = add i32 "+left+","+right);
                    Num++;
                    return "%"+(Num-1);
                }
                else if(Objects.equals(ctx.Addfunc().getText(), "-")){
                    results+="%"+Num+" = sub i32 "+left+","+right+"\n";
//                    System.out.println("%"+Num+" = sub i32 "+left+","+right);
                    Num++;
                    return "%"+(Num-1);
                }
                else {
//                    System.out.println("not found");
                }
                break;
        }
        return null;
    }

    @Override
    public String visitMulexp(calcParser.MulexpContext ctx) {
        switch (ctx.children.size()){
            case 1:
                return visitUnaryexp(ctx.unaryexp());
            case 3:
                String left=visitMulexp(ctx.mulexp());
                String right=visitUnaryexp(ctx.unaryexp());
                if(ctx.Mulfunc().getText().equals("*")){
                    results+="%"+Num+" = mul i32 "+left+","+right+"\n";
//                    System.out.println("%"+Num+" = mul i32 "+left+","+right);
                    Num++;
                    return "%"+(Num-1);
                }
                else if(ctx.Mulfunc().getText().equals("/")) {
                    results+="%" + Num + " = sdiv i32 " + left + "," + right+"\n";
//                    System.out.println("%" + Num + " = sdiv i32 " + left + "," + right);
                    Num++;
                    return "%" + (Num - 1);
                }
                else if(ctx.Mulfunc().getText().equals("%")) {
                    results+="%" + Num + " = srem i32 " + left + "," + right+"\n";
//                    System.out.println("%" + Num + " = srem i32 " + left + "," + right);
                    Num++;
                    return "%" + (Num - 1);
                }
                break;
        }
        return null;
    }

    @Override
    public String visitUnaryexp(calcParser.UnaryexpContext ctx) {
        switch (ctx.children.size()){
            case 1:
                return visitPrimaryexp(ctx.primaryexp());
            case 2:
                String right=visitUnaryexp(ctx.unaryexp());
                if(ctx.Addfunc().getText().equals("+")){
                    results+="%"+Num+" = add i32 0, "+right+"\n";
//                    System.out.println("%"+Num+" = add i32 0, "+right);
                    Num++;
                    return "%"+(Num-1);
                }
                else if(ctx.Addfunc().getText().equals("-")){
                    results+="%"+Num+" = sub i32 0, "+right+"\n";
//                    System.out.println("%"+Num+" = sub i32 0, "+right);
                    Num++;
                    return "%"+(Num-1);
                }
            default:
                String s = ctx.Idigit().getText();
                if(s.equals("getint")){
                    results+="%"+Num+" = call i32 @getint()\n";
                    Num++;
                    return "%"+(Num-1);
                }
                else if(s.equals("putint")){
                    String tt=visitFuncrParams(ctx.funcrParams());
                    results+="call void @putint(i32 "+tt+")\n";
                    return null;
                }
                else if(s.equals("getch")){
                    results+="%"+Num+" = call i32 @getch()\n";
                    Num++;
                    return "%"+(Num-1);
                }
                else if(s.equals("putch")){
                    String tt=visitFuncrParams(ctx.funcrParams());
                    results+="call void @putch(i32 "+tt+")\n";
                    return null;
                }
        }
        return null;
    }

    @Override
    public String visitPrimaryexp(calcParser.PrimaryexpContext ctx) {
        switch (ctx.children.size()){
            case 1:
                if(ctx.Number()!=null){
                    String s = ctx.Number().getText();
                    int temp=getnumber(s);
                    return String.valueOf(temp);
                }
                else {
                    String a=visitLval(ctx.lval());
                    Var var=VarList.getInstance().getVar(ctx.lval().getText());
                    return a;
//                    return var.getNum();
                }
            case 3:
                return visitExp(ctx.exp());
        }
        return null;
    }

    @Override
    public Void visitDecl(calcParser.DeclContext ctx) {
        if(ctx.constDecl()!=null){
            visit(ctx.constDecl());
        }
        else {
            visit(ctx.varDecl());
        }
        return null;
    }

    @Override
    public Void visitConstDecl(calcParser.ConstDeclContext ctx) {
        for(int i=0;i<ctx.constDef().size();i++){
            visit(ctx.constDef(i));
        }
        return null;
    }

    @Override
    public Void visitConstDef(calcParser.ConstDefContext ctx) {
        results+="%"+Num+" = alloca i32\n";
        String ident=ctx.Idigit().getText();
        if(VarList.getInstance().getVar(ident)!=null){
            System.exit(-1);
        }
        Var var=new Var();
        var.setName(ident);
        var.setNum("%"+Num);
        var.setInit(true);
        var.setIsconst(true);
        VarList list=VarList.getInstance();
        list.add(var);
        Num++;
        String temp=visitConstInitVal(ctx.constInitVal());
        String loc=list.getVar(ctx.Idigit().getText()).getNum();
        results+="store i32 "+temp+", i32* " +loc+"\n";
        return null;
    }

    @Override
    public String visitConstInitVal(calcParser.ConstInitValContext ctx) {
        return visitConstExp(ctx.constExp());
    }

    @Override
    public String visitConstExp(calcParser.ConstExpContext ctx) {
        return visitAddexp(ctx.addexp());
    }

    @Override
    public Void visitVarDecl(calcParser.VarDeclContext ctx) {
        for(int i=0;i<ctx.varDef().size();i++){
            visit(ctx.varDef(i));
        }
        return null;
    }

    @Override
    public Void visitVarDef(calcParser.VarDefContext ctx) {
        switch (ctx.children.size()){
            case 1:
                results+="%"+Num+" = alloca i32\n";
                String ident=ctx.Idigit().getText();
                if(VarList.getInstance().getVar(ident)!=null){
                    System.exit(-1);
                }
                Var var=new Var();
                var.setName(ident);
                var.setNum("%"+Num);
                var.setIsconst(false);
                var.setInit(false);
                VarList list=VarList.getInstance();
                list.add(var);
                Num++;
                break;
            case 3:
                results+="%"+Num+" = alloca i32\n";
                ident=ctx.Idigit().getText();
                if(VarList.getInstance().getVar(ident)!=null){
                    System.exit(-1);
                }
                var=new Var();
                var.setName(ident);
                var.setNum("%"+Num);
                var.setInit(true);
                var.setIsconst(false);
                list=VarList.getInstance();
                list.add(var);
                Num++;
                String temp=visitInitVal(ctx.initVal());
                String loc=list.getVar(ctx.Idigit().getText()).getNum();
                results+="store i32 "+temp+", i32* " +loc+"\n";
                break;
        }
        return null;
    }

    @Override
    public String visitInitVal(calcParser.InitValContext ctx) {
        return visitExp(ctx.exp());
    }

    @Override
    public Void visitBlockItem(calcParser.BlockItemContext ctx) {
        if(ctx.decl()!=null){
            visit(ctx.decl());
        }
        else {
            visit(ctx.stmt());
        }
        return null;
    }

    @Override
    public String visitLval(calcParser.LvalContext ctx) {
        Var var=VarList.getInstance().getVar(ctx.getText());
        if(var.isInit()){
            results+="%"+Num+" = load i32, i32* "+var.getNum()+"\n";
            Num++;
        }
        return "%"+(Num-1);
    }

    @Override
    public String visitFuncrParams(calcParser.FuncrParamsContext ctx) {
        String s = "";
        for(int i=0;i<ctx.exp().size();i++){
            s+=visitExp(ctx.exp(i));
        }
        return s;
    }
}
