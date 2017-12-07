package com.noprestige.kanaquiz;

class Hiragana extends QuestionManagement
{
    private static final KanaQuestion[] KANA_SET_1 = {
            new KanaQuestion('あ', "a"),
            new KanaQuestion('い', "i"),
            new KanaQuestion('う', "u"),
            new KanaQuestion('え', "e"),
            new KanaQuestion('お', "o")};

    private static final KanaQuestion[] KANA_SET_2_BASE = {
            new KanaQuestion('か', "ka"),
            new KanaQuestion('き', "ki"),
            new KanaQuestion('く', "ku"),
            new KanaQuestion('け', "ke"),
            new KanaQuestion('こ', "ko")};

    private static final KanaQuestion[] KANA_SET_2_DAKUTEN = {
            new KanaQuestion('が', "ga"),
            new KanaQuestion('ぎ', "gi"),
            new KanaQuestion('ぐ', "gu"),
            new KanaQuestion('げ', "ge"),
            new KanaQuestion('ご', "go")};

    private static final KanaQuestion[] KANA_SET_2_BASE_DIGRAPHS = {
            new KanaQuestion("きゃ", "kya"),
            new KanaQuestion("きゅ", "kyu"),
            new KanaQuestion("きょ", "kyo")};

    private static final KanaQuestion[] KANA_SET_2_DAKUTEN_DIGRAPHS = {
            new KanaQuestion("ぎゃ", "gya"),
            new KanaQuestion("ぎゅ", "gyu"),
            new KanaQuestion("ぎょ", "gyo")};

    private static final KanaQuestion[] KANA_SET_3_BASE = {
            new KanaQuestion('さ', "sa"),
            new KanaQuestion('し', "shi"),
            new KanaQuestion('す', "su"),
            new KanaQuestion('せ', "se"),
            new KanaQuestion('そ', "so")};

    private static final KanaQuestion[] KANA_SET_3_DAKUTEN = {
            new KanaQuestion('ざ', "za"),
            new KanaQuestion('じ', "ji"),
            new KanaQuestion('ず', "zu"),
            new KanaQuestion('ぜ', "ze"),
            new KanaQuestion('ぞ', "zo")};

    private static final KanaQuestion[] KANA_SET_3_BASE_DIGRAPHS = {
            new KanaQuestion("しゃ", "sha"),
            new KanaQuestion("しゅ", "shu"),
            new KanaQuestion("しょ", "sho")};

    private static final KanaQuestion[] KANA_SET_3_DAKUTEN_DIGRAPHS = {
            new KanaQuestion("じゃ", new String[]{"ja", "jya"}),
            new KanaQuestion("じゅ", new String[]{"ju", "jyu"}),
            new KanaQuestion("じょ", new String[]{"jo", "jyo"})};

    private static final KanaQuestion[] KANA_SET_4_BASE = {
            new KanaQuestion('た', "ta"),
            new KanaQuestion('ち', "chi"),
            new KanaQuestion('つ', "tsu"),
            new KanaQuestion('て', "te"),
            new KanaQuestion('と', "to")};

    private static final KanaQuestion[] KANA_SET_4_DAKUTEN = {
            new KanaQuestion('だ', "da"),
            new KanaQuestion('ぢ', "ji"),
            new KanaQuestion('づ', "zu"),
            new KanaQuestion('で', "de"),
            new KanaQuestion('ど', "do")};

    private static final KanaQuestion[] KANA_SET_4_BASE_DIGRAPHS = {
            new KanaQuestion("ちゃ", "cha"),
            new KanaQuestion("ちゅ", "chu"),
            new KanaQuestion("ちょ", "cho")};

    private static final KanaQuestion[] KANA_SET_4_DAKUTEN_DIGRAPHS = {
            new KanaQuestion("ぢゃ", new String[]{"ja", "dzya"}),
            new KanaQuestion("ぢゅ", new String[]{"ju", "dzyu"}),
            new KanaQuestion("ぢょ", new String[]{"jo", "dzyo"})};

    private static final KanaQuestion[] KANA_SET_5 = {
            new KanaQuestion('な', "na"),
            new KanaQuestion('に', "ni"),
            new KanaQuestion('ぬ', "nu"),
            new KanaQuestion('ね', "ne"),
            new KanaQuestion('の', "no")};

    private static final KanaQuestion[] KANA_SET_5_DIGRAPHS = {
            new KanaQuestion("にゃ", "nya"),
            new KanaQuestion("にゅ", "nyu"),
            new KanaQuestion("にょ", "nyo")};

    private static final KanaQuestion[] KANA_SET_6_BASE = {
            new KanaQuestion('は', "ha"),
            new KanaQuestion('ひ', "hi"),
            new KanaQuestion('ふ', new String[]{"fu", "hu"}),
            new KanaQuestion('へ', "he"),
            new KanaQuestion('ほ', "ho")};

    private static final KanaQuestion[] KANA_SET_6_DAKUTEN = {
            new KanaQuestion('ば', "ba"),
            new KanaQuestion('び', "bi"),
            new KanaQuestion('ぶ', "bu"),
            new KanaQuestion('べ', "be"),
            new KanaQuestion('ぼ', "bo")};

    private static final KanaQuestion[] KANA_SET_6_HANDAKUTEN = {
            new KanaQuestion('ぱ', "pa"),
            new KanaQuestion('ぴ', "pi"),
            new KanaQuestion('ぷ', "pu"),
            new KanaQuestion('ぺ', "pe"),
            new KanaQuestion('ぽ', "po")};

    private static final KanaQuestion[] KANA_SET_6_BASE_DIGRAPHS = {
            new KanaQuestion("ひゃ", "hya"),
            new KanaQuestion("ひゅ", "hyu"),
            new KanaQuestion("ひょ", "hyo")};

    private static final KanaQuestion[] KANA_SET_6_DAKUTEN_DIGRAPHS = {
            new KanaQuestion("びゃ", "bya"),
            new KanaQuestion("びゅ", "byu"),
            new KanaQuestion("びょ", "byo")};

    private static final KanaQuestion[] KANA_SET_6_HANDAKUTEN_DIGRAPHS = {
            new KanaQuestion("ぴゃ", "pya"),
            new KanaQuestion("ぴゅ", "pyu"),
            new KanaQuestion("ぴょ", "pyo")};

    private static final KanaQuestion[] KANA_SET_7 = {
            new KanaQuestion('ま', "ma"),
            new KanaQuestion('み', "mi"),
            new KanaQuestion('む', "mu"),
            new KanaQuestion('め', "me"),
            new KanaQuestion('も', "mo")};

    private static final KanaQuestion[] KANA_SET_7_DIGRAPHS = {
            new KanaQuestion("みゃ", "mya"),
            new KanaQuestion("みゅ", "myu"),
            new KanaQuestion("みょ", "myo")};

    private static final KanaQuestion[] KANA_SET_8 = {
            new KanaQuestion('ら', "ra"),
            new KanaQuestion('り', "ri"),
            new KanaQuestion('る', "ru"),
            new KanaQuestion('れ', "re"),
            new KanaQuestion('ろ', "ro")};

    private static final KanaQuestion[] KANA_SET_8_DIGRAPHS = {
            new KanaQuestion("りゃ", "rya"),
            new KanaQuestion("りゅ", "ryu"),
            new KanaQuestion("りょ", "ryo")};

    private static final KanaQuestion[] KANA_SET_9 = {
            new KanaQuestion('や', "ya"),
            new KanaQuestion('ゆ', "yu"),
            new KanaQuestion('よ', "yo")};

    private static final KanaQuestion[] KANA_SET_10_W_GROUP = {
            new KanaQuestion('わ', "wa"),
            new KanaQuestion('を', "wo")};

    private static final KanaQuestion[] KANA_SET_10_N_CONSONANT = {
            new KanaQuestion('ん', "n")};

    private static final int PREFID_1 = R.string.prefid_hiragana_1;
    private static final int PREFID_2 = R.string.prefid_hiragana_2;
    private static final int PREFID_3 = R.string.prefid_hiragana_3;
    private static final int PREFID_4 = R.string.prefid_hiragana_4;
    private static final int PREFID_5 = R.string.prefid_hiragana_5;
    private static final int PREFID_6 = R.string.prefid_hiragana_6;
    private static final int PREFID_7 = R.string.prefid_hiragana_7;
    private static final int PREFID_8 = R.string.prefid_hiragana_8;
    private static final int PREFID_9 = R.string.prefid_hiragana_9;
    private static final int PREFID_10 = R.string.prefid_hiragana_10;

    static final Hiragana QUESTIONS = new Hiragana();

    private Hiragana()
    {
    }

    KanaQuestion[] getKanaSet(int number, Diacritic diacritic, boolean isDigraphs) //TODO: Clean this up
    {
        if (isDigraphs)
        {
            switch (diacritic)
            {
                case NO_DIACRITIC:
                    switch (number)
                    {
                        case 2:
                            return KANA_SET_2_BASE_DIGRAPHS;
                        case 3:
                            return KANA_SET_3_BASE_DIGRAPHS;
                        case 4:
                            return KANA_SET_4_BASE_DIGRAPHS;
                        case 5:
                            return KANA_SET_5_DIGRAPHS;
                        case 6:
                            return KANA_SET_6_BASE_DIGRAPHS;
                        case 7:
                            return KANA_SET_7_DIGRAPHS;
                        case 8:
                            return KANA_SET_8_DIGRAPHS;
                    }
                    break;

                case DAKUTEN:
                    switch (number)
                    {
                        case 2:
                            return KANA_SET_2_DAKUTEN_DIGRAPHS;
                        case 3:
                            return KANA_SET_3_DAKUTEN_DIGRAPHS;
                        case 4:
                            return KANA_SET_4_DAKUTEN_DIGRAPHS;
                        case 6:
                            return KANA_SET_6_DAKUTEN_DIGRAPHS;
                    }
                    break;

                case HANDAKUTEN:
                    switch (number)
                    {
                        case 6:
                            return KANA_SET_6_HANDAKUTEN_DIGRAPHS;
                    }
                    break;
            }
            throw new NullPointerException("Kana set " + number + " " + diacritic.name() + " digraphs does not exist");
        }
        else
        {
            switch (diacritic)
            {
                case NO_DIACRITIC:
                    switch (number)
                    {
                        case 1:
                            return KANA_SET_1;
                        case 2:
                            return KANA_SET_2_BASE;
                        case 3:
                            return KANA_SET_3_BASE;
                        case 4:
                            return KANA_SET_4_BASE;
                        case 5:
                            return KANA_SET_5;
                        case 6:
                            return KANA_SET_6_BASE;
                        case 7:
                            return KANA_SET_7;
                        case 8:
                            return KANA_SET_8;
                        case 9:
                            return KANA_SET_9;
                        case 10:
                            return KANA_SET_10_W_GROUP;
                    }
                    break;

                case DAKUTEN:
                    switch (number)
                    {
                        case 2:
                            return KANA_SET_2_DAKUTEN;
                        case 3:
                            return KANA_SET_3_DAKUTEN;
                        case 4:
                            return KANA_SET_4_DAKUTEN;
                        case 6:
                            return KANA_SET_6_DAKUTEN;
                    }
                    break;

                case HANDAKUTEN:
                    switch (number)
                    {
                        case 6:
                            return KANA_SET_6_HANDAKUTEN;
                    }
                    break;

                case CONSONANT:
                    switch (number)
                    {
                        case 10:
                            return KANA_SET_10_N_CONSONANT;
                    }
                    break;
            }
            throw new NullPointerException("Kana set " + number + " " + diacritic.name() + " monographs does not exist");
        }
    }

    int getPrefId(int number)
    {
        switch (number)
        {
            case 1:
                return PREFID_1;
            case 2:
                return PREFID_2;
            case 3:
                return PREFID_3;
            case 4:
                return PREFID_4;
            case 5:
                return PREFID_5;
            case 6:
                return PREFID_6;
            case 7:
                return PREFID_7;
            case 8:
                return PREFID_8;
            case 9:
                return PREFID_9;
            case 10:
                return PREFID_10;
            default:
                throw new NullPointerException("PrefId: " + number + " does not exist");
        }
    }
}
