package enums.parsing;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum TabelaParsingEnum {

    CODIGO_52_1(52, 1, "PROGRAM@IDENTIFICADOR@;@BLOCO@."),
    CODIGO_53_2(53, 2, "DCLROT@DCLCONST@DCLVAR@DCLPROC@CORPO"),
    CODIGO_53_3(53, 3, "DCLROT@DCLCONST@DCLVAR@DCLPROC@CORPO"),
    CODIGO_53_4(53, 4, "DCLROT@DCLCONST@DCLVAR@DCLPROC@CORPO"),
    CODIGO_53_5(53, 5, "DCLROT@DCLCONST@DCLVAR@DCLPROC@CORPO"),
    CODIGO_53_6(53, 6, "DCLROT@DCLCONST@DCLVAR@DCLPROC@CORPO"),
    CODIGO_54_2(54, 2, "LABEL@LID@;"),
    CODIGO_54_3(54, 3, "NULL"),
    CODIGO_54_4(54, 4, "NULL"),
    CODIGO_54_5(54, 5, "NULL"),
    CODIGO_54_6(54, 6, "NULL"),
    CODIGO_55_25(55, 25, "IDENTIFICADOR@REPIDENT"),
    CODIGO_56_39(56, 39, "NULL"),
    CODIGO_56_46(56, 46, ",@IDENTIFICADOR@REPIDENT"),
    CODIGO_56_47(56, 47, "NULL"),
    CODIGO_57_3(57, 3, "CONST@IDENTIFICADOR@=@INTEIRO@;@LDCONST"),
    CODIGO_57_4(57, 4, "NULL"),
    CODIGO_57_5(57, 5, "NULL"),
    CODIGO_57_6(57, 6, "NULL"),
    CODIGO_58_4(58, 4, "NULL"),
    CODIGO_58_5(58, 5, "NULL"),
    CODIGO_58_6(58, 6, "NULL"),
    CODIGO_58_25(58, 25, "IDENTIFICADOR@=@INTEIRO@;@LDCONST"),
    CODIGO_59_4(59, 4, "VAR@LID@:@TIPO@;@LDVAR"),
    CODIGO_59_5(59, 5, "NULL"),
    CODIGO_59_6(59, 6, "NULL"),
    CODIGO_60_5(60, 5, "NULL"),
    CODIGO_60_6(60, 6, "NULL"),
    CODIGO_60_25(60, 25, "LID@:@TIPO@;@LDVAR"),
    CODIGO_61_8(61, 8, "INTEGER"),
    CODIGO_61_9(61, 9, "ARRAY@[@INTEIRO@..@INTEIRO@]@OF@INTEGER"),
    CODIGO_62_5(62, 5, "PROCEDURE@IDENTIFICADOR@DEFPAR@;@BLOCO@;@DCLPROC"),
    CODIGO_62_6(62, 6, "NULL"),
    CODIGO_63_36(63, 36, "(@LID@:@INTEGER@)"),
    CODIGO_63_39(63, 39, "NULL"),
    CODIGO_64_6(64, 6, "BEGIN@COMANDO@REPCOMANDO@END"),
    CODIGO_65_7(65, 7, "NULL"),
    CODIGO_65_47(65, 47, ";@COMANDO@REPCOMANDO"),
    CODIGO_66_6(66, 6, "CORPO"),
    CODIGO_66_7(66, 7, "NULL"),
    CODIGO_66_11(66, 11, "CALL@IDENTIFICADOR@PARAMETROS"),
    CODIGO_66_12(66, 12, "GOTO@IDENTIFICADOR"),
    CODIGO_66_13(66, 13, "IF@EXPRESSAO@THEN@COMANDO@ELSEPARTE"),
    CODIGO_66_15(66, 15, "NULL"),
    CODIGO_66_16(66, 16, "WHILE@EXPRESSAO@DO@COMANDO"),
    CODIGO_66_18(66, 18, "REPEAT@COMANDO@UNTIL@EXPRESSAO"),
    CODIGO_66_19(66, 19, "NULL"),
    CODIGO_66_20(66, 20, "READLN@(@VARIAVEL@REPVARIAVEL@)"),
    CODIGO_66_21(66, 21, "WRITELN@(@ITEMSAIDA@REPITEM@)"),
    CODIGO_66_25(66, 25, "IDENTIFICADOR@RCOMID"),
    CODIGO_66_27(66, 27, "FOR@IDENTIFICADOR@:=@EXPRESSAO@TO@EXPRESSAO@DO@COMANDO"),
    CODIGO_66_29(66, 29, "CASE@EXPRESSAO@OF@CONDCASE@END"),
    CODIGO_66_47(66, 47, "NULL"),
    CODIGO_67_34(67, 34, "RVAR@:=@EXPRESSAO"),
    CODIGO_67_38(67, 38, "RVAR@:=@EXPRESSAO"),
    CODIGO_67_39(67, 39, ":@COMANDO"),
    CODIGO_68_34(68, 34, "[@EXPRESSAO@]"),
    CODIGO_68_38(68, 38, "NULL"),
    CODIGO_69_7(69, 7, "NULL"),
    CODIGO_69_15(69, 15, "NULL"),
    CODIGO_69_19(69, 19, "NULL"),
    CODIGO_69_36(69, 36, "(@EXPRESSAO@REPPAR@)"),
    CODIGO_69_47(69, 47, "NULL"),
    CODIGO_70_37(70, 37, "NULL"),
    CODIGO_70_46(70, 46, ",@EXPRESSAO@REPPAR"),
    CODIGO_71_7(71, 7, "NULL"),
    CODIGO_71_15(71, 15, "ELSE@COMANDO"),
    CODIGO_71_19(71, 19, "NULL"),
    CODIGO_71_47(71, 47, "NULL"),
    CODIGO_72_25(72, 25, "IDENTIFICADOR@VARIAVEL1"),
    CODIGO_73_7(73, 7, "NULL"),
    CODIGO_73_10(73, 10, "NULL"),
    CODIGO_73_14(73, 14, "NULL"),
    CODIGO_73_15(73, 15, "NULL"),
    CODIGO_73_17(73, 17, "NULL"),
    CODIGO_73_19(73, 19, "NULL"),
    CODIGO_73_22(73, 22, "NULL"),
    CODIGO_73_23(73, 23, "NULL"),
    CODIGO_73_28(73, 28, "NULL"),
    CODIGO_73_30(73, 30, "NULL"),
    CODIGO_73_31(73, 31, "NULL"),
    CODIGO_73_32(73, 32, "NULL"),
    CODIGO_73_33(73, 33, "NULL"),
    CODIGO_73_34(73, 34, "[@EXPRESSAO@]"),
    CODIGO_73_35(73, 35, "NULL"),
    CODIGO_73_37(73, 37, "NULL"),
    CODIGO_73_40(73, 40, "NULL"),
    CODIGO_73_41(73, 41, "NULL"),
    CODIGO_73_42(73, 42, "NULL"),
    CODIGO_73_43(73, 43, "NULL"),
    CODIGO_73_44(73, 44, "NULL"),
    CODIGO_73_45(73, 45, "NULL"),
    CODIGO_73_46(73, 46, "NULL"),
    CODIGO_73_47(73, 47, "NULL"),
    CODIGO_74_37(74, 37, "NULL"),
    CODIGO_74_46(74, 46, ",@VARIAVEL@REPVARIAVEL"),
    CODIGO_75_24(75, 24, "EXPRESSAO"),
    CODIGO_75_25(75, 25, "EXPRESSAO"),
    CODIGO_75_26(75, 26, "EXPRESSAO"),
    CODIGO_75_30(75, 30, "EXPRESSAO"),
    CODIGO_75_31(75, 31, "EXPRESSAO"),
    CODIGO_75_36(75, 36, "EXPRESSAO"),
    CODIGO_75_48(75, 48, "LITERAL"),
    CODIGO_76_37(76, 37, "NULL"),
    CODIGO_76_46(76, 46, ",@ITEMSAIDA@REPITEM"),
    CODIGO_77_24(77, 24, "EXPSIMP@REPEXPSIMP"),
    CODIGO_77_25(77, 25, "EXPSIMP@REPEXPSIMP"),
    CODIGO_77_26(77, 26, "EXPSIMP@REPEXPSIMP"),
    CODIGO_77_30(77, 30, "EXPSIMP@REPEXPSIMP"),
    CODIGO_77_31(77, 31, "EXPSIMP@REPEXPSIMP"),
    CODIGO_77_36(77, 36, "EXPSIMP@REPEXPSIMP"),
    CODIGO_78_7(78, 7, "NULL"),
    CODIGO_78_10(78, 10, "NULL"),
    CODIGO_78_14(78, 14, "NULL"),
    CODIGO_78_15(78, 15, "NULL"),
    CODIGO_78_17(78, 17, "NULL"),
    CODIGO_78_19(78, 19, "NULL"),
    CODIGO_78_28(78, 28, "NULL"),
    CODIGO_78_35(78, 35, "NULL"),
    CODIGO_78_37(78, 37, "NULL"),
    CODIGO_78_40(78, 40, "@EXPSIMP"),
    CODIGO_78_41(78, 41, ">@EXPSIMP"),
    CODIGO_78_42(78, 42, ">=@EXPSIMP"),
    CODIGO_78_43(78, 43, "<@EXPSIMP"),
    CODIGO_78_44(78, 44, "<=@EXPSIMP"),
    CODIGO_78_45(78, 45, "<>@EXPSIMP"),
    CODIGO_78_46(78, 46, "NULL"),
    CODIGO_78_47(78, 47, "NULL"),
    CODIGO_79_24(79, 24, "TERMO@REPEXP"),
    CODIGO_79_25(79, 25, "TERMO@REPEXP"),
    CODIGO_79_26(79, 26, "TERMO@REPEXP"),
    CODIGO_79_30(79, 30, "+@TERMO@REPEXP"),
    CODIGO_79_31(79, 31, "-@TERMO@REPEXP"),
    CODIGO_79_36(79, 36, "TERMO@REPEXP"),
    CODIGO_80_7(80, 7, "NULL"),
    CODIGO_80_10(80, 10, "NULL"),
    CODIGO_80_14(80, 14, "NULL"),
    CODIGO_80_15(80, 15, "NULL"),
    CODIGO_80_17(80, 17, "NULL"),
    CODIGO_80_19(80, 19, "NULL"),
    CODIGO_80_22(80, 22, "OR@TERMO@REPEXP"),
    CODIGO_80_28(80, 28, "NULL"),
    CODIGO_80_30(80, 30, "+@TERMO@REPEXP"),
    CODIGO_80_31(80, 31, "-@TERMO@REPEXP"),
    CODIGO_80_35(80, 35, "NULL"),
    CODIGO_80_37(80, 37, "NULL"),
    CODIGO_80_40(80, 40, "NULL"),
    CODIGO_80_41(80, 41, "NULL"),
    CODIGO_80_42(80, 42, "NULL"),
    CODIGO_80_43(80, 43, "NULL"),
    CODIGO_80_44(80, 44, "NULL"),
    CODIGO_80_45(80, 45, "NULL"),
    CODIGO_80_46(80, 46, "NULL"),
    CODIGO_80_47(80, 47, "NULL"),
    CODIGO_81_24(81, 24, "FATOR@REPTERMO"),
    CODIGO_81_25(81, 25, "FATOR@REPTERMO"),
    CODIGO_81_26(81, 26, "FATOR@REPTERMO"),
    CODIGO_81_36(81, 36, "FATOR@REPTERMO"),
    CODIGO_82_7(82, 7, "NULL"),
    CODIGO_82_10(82, 10, "NULL"),
    CODIGO_82_14(82, 14, "NULL"),
    CODIGO_82_15(82, 15, "NULL"),
    CODIGO_82_17(82, 17, "NULL"),
    CODIGO_82_19(82, 19, "NULL"),
    CODIGO_82_22(82, 22, "NULL"),
    CODIGO_82_23(82, 23, "AND@FATOR@REPTERMO"),
    CODIGO_82_28(82, 28, "NULL"),
    CODIGO_82_30(82, 30, "NULL"),
    CODIGO_82_31(82, 31, "NULL"),
    CODIGO_82_32(82, 32, "*@FATOR@REPTERMO"),
    CODIGO_82_33(82, 33, "/@FATOR@REPTERMO"),
    CODIGO_82_35(82, 35, "NULL"),
    CODIGO_82_37(82, 37, "NULL"),
    CODIGO_82_40(82, 40, "NULL"),
    CODIGO_82_41(82, 41, "NULL"),
    CODIGO_82_42(82, 42, "NULL"),
    CODIGO_82_43(82, 43, "NULL"),
    CODIGO_82_44(82, 44, "NULL"),
    CODIGO_82_45(82, 45, "NULL"),
    CODIGO_82_46(82, 46, "NULL"),
    CODIGO_82_47(82, 47, "NULL"),
    CODIGO_83_24(83, 24, "NOT@FATOR"),
    CODIGO_83_25(83, 25, "VARIAVEL"),
    CODIGO_83_26(83, 26, "INTEIRO"),
    CODIGO_83_36(83, 36, "(@EXPRESSAO@)"),
    CODIGO_84_26(84, 26, "INTEIRO@RPINTEIRO@:@COMANDO@CONTCASE"),
    CODIGO_85_7(85, 7, "NULL"),
    CODIGO_85_47(85, 47, ";@CONDCASE"),
    CODIGO_86_39(86, 39, "NULL"),
    CODIGO_86_46(86, 46, ",@INTEIRO@RPINTEIRO");

    private Integer idKeyToken;
    private Integer idKeyParsing;
    private String producao;

    TabelaParsingEnum(Integer idKeyToken, Integer idKeyParsing, String producao) {
        this.idKeyToken = idKeyToken;
        this.idKeyParsing = idKeyParsing;
        this.producao = producao;
    }

    public Integer getIdKeyToken() {
        return idKeyToken;
    }

    public void setIdKeyToken(Integer idKeyToken) {
        this.idKeyToken = idKeyToken;
    }

    public Integer getIdKeyParsing() {
        return idKeyParsing;
    }

    public void setIdKeyParsing(Integer idKeyParsing) {
        this.idKeyParsing = idKeyParsing;
    }

    public String getProducao() {
        return producao;
    }

    public void setProducao(String producao) {
        this.producao = producao;
    }
    
    public List<String> getProducoes(){
        return Arrays.asList(this.producao.split("@"));
    }
    
    public List<String> getProducoesInvertida(){
        List<String> producoes = getProducoes();
        Collections.reverse(producoes);
        return producoes;
    }
    
    public static TabelaParsingEnum getValueByKeys(Integer idKeyToken, Integer idKeyParsing){        
        for (TabelaParsingEnum tbParsing: TabelaParsingEnum.values()){
            if (tbParsing.getIdKeyToken().equals(idKeyToken) && tbParsing.getIdKeyParsing().equals(idKeyParsing)){
                return tbParsing;
            }
        }        
        return null;
    }

}
