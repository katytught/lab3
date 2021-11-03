// Generated from .\calc.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class calcLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		FuncType=10, Ident=11, Idigit=12, Nondigit=13, Addfunc=14, Mulfunc=15, 
		Number=16, Decimalconst=17, Octalconst=18, Hexadecimalconst=19, Hexadecimalprefix=20, 
		Nonzerodigit=21, Octaldigit=22, Digit=23, Hexadecimaldigit=24, WHITE_SPACE=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"FuncType", "Ident", "Idigit", "Nondigit", "Addfunc", "Mulfunc", "Number", 
			"Decimalconst", "Octalconst", "Hexadecimalconst", "Hexadecimalprefix", 
			"Nonzerodigit", "Octaldigit", "Digit", "Hexadecimaldigit", "WHITE_SPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'const'", "','", "';'", "'='", "'{'", "'}'", "'return'", 
			"'int'", "'main'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "FuncType", 
			"Ident", "Idigit", "Nondigit", "Addfunc", "Mulfunc", "Number", "Decimalconst", 
			"Octalconst", "Hexadecimalconst", "Hexadecimalprefix", "Nonzerodigit", 
			"Octaldigit", "Digit", "Hexadecimaldigit", "WHITE_SPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public calcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "calc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u0096\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\7\r]\n\r\f\r\16\r`\13\r\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\21\5\21k\n\21\3\22\3\22\3\22\7\22p\n"+
		"\22\f\22\16\22s\13\22\3\23\3\23\7\23w\n\23\f\23\16\23z\13\23\3\24\3\24"+
		"\7\24~\n\24\f\24\16\24\u0081\13\24\3\25\3\25\3\25\3\25\5\25\u0087\n\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\5\30\u008f\n\30\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\2\2\33\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\3\2\7"+
		"\5\2C\\aac|\4\2--//\5\2\'\',,\61\61\5\2\62;CHch\7\2\13\f\17\17\"\"))~"+
		"~\2\u009f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2\2\5\67\3\2\2\2\79\3\2"+
		"\2\2\t?\3\2\2\2\13A\3\2\2\2\rC\3\2\2\2\17E\3\2\2\2\21G\3\2\2\2\23I\3\2"+
		"\2\2\25P\3\2\2\2\27T\3\2\2\2\31Y\3\2\2\2\33a\3\2\2\2\35c\3\2\2\2\37e\3"+
		"\2\2\2!j\3\2\2\2#l\3\2\2\2%t\3\2\2\2\'{\3\2\2\2)\u0086\3\2\2\2+\u0088"+
		"\3\2\2\2-\u008a\3\2\2\2/\u008e\3\2\2\2\61\u0090\3\2\2\2\63\u0092\3\2\2"+
		"\2\65\66\7*\2\2\66\4\3\2\2\2\678\7+\2\28\6\3\2\2\29:\7e\2\2:;\7q\2\2;"+
		"<\7p\2\2<=\7u\2\2=>\7v\2\2>\b\3\2\2\2?@\7.\2\2@\n\3\2\2\2AB\7=\2\2B\f"+
		"\3\2\2\2CD\7?\2\2D\16\3\2\2\2EF\7}\2\2F\20\3\2\2\2GH\7\177\2\2H\22\3\2"+
		"\2\2IJ\7t\2\2JK\7g\2\2KL\7v\2\2LM\7w\2\2MN\7t\2\2NO\7p\2\2O\24\3\2\2\2"+
		"PQ\7k\2\2QR\7p\2\2RS\7v\2\2S\26\3\2\2\2TU\7o\2\2UV\7c\2\2VW\7k\2\2WX\7"+
		"p\2\2X\30\3\2\2\2Y^\5\33\16\2Z]\5\33\16\2[]\5/\30\2\\Z\3\2\2\2\\[\3\2"+
		"\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\32\3\2\2\2`^\3\2\2\2ab\t\2\2\2b\34"+
		"\3\2\2\2cd\t\3\2\2d\36\3\2\2\2ef\t\4\2\2f \3\2\2\2gk\5#\22\2hk\5%\23\2"+
		"ik\5\'\24\2jg\3\2\2\2jh\3\2\2\2ji\3\2\2\2k\"\3\2\2\2lq\5+\26\2mp\5+\26"+
		"\2np\7\62\2\2om\3\2\2\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2r$\3\2"+
		"\2\2sq\3\2\2\2tx\7\62\2\2uw\5-\27\2vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3"+
		"\2\2\2y&\3\2\2\2zx\3\2\2\2{\177\5)\25\2|~\5\61\31\2}|\3\2\2\2~\u0081\3"+
		"\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080(\3\2\2\2\u0081\177\3\2\2\2"+
		"\u0082\u0083\7\62\2\2\u0083\u0087\7z\2\2\u0084\u0085\7\62\2\2\u0085\u0087"+
		"\7Z\2\2\u0086\u0082\3\2\2\2\u0086\u0084\3\2\2\2\u0087*\3\2\2\2\u0088\u0089"+
		"\4\63;\2\u0089,\3\2\2\2\u008a\u008b\4\629\2\u008b.\3\2\2\2\u008c\u008f"+
		"\7\62\2\2\u008d\u008f\5+\26\2\u008e\u008c\3\2\2\2\u008e\u008d\3\2\2\2"+
		"\u008f\60\3\2\2\2\u0090\u0091\t\5\2\2\u0091\62\3\2\2\2\u0092\u0093\t\6"+
		"\2\2\u0093\u0094\3\2\2\2\u0094\u0095\b\32\2\2\u0095\64\3\2\2\2\f\2\\^"+
		"joqx\177\u0086\u008e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}