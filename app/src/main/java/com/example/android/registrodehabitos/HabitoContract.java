package com.example.android.registrodehabitos;

import android.provider.BaseColumns;

/**
 * Created by Andrik on 10/04/2018.
 */

public final class HabitoContract {

    private HabitoContract(){}

    public static final class HabitoEntry implements BaseColumns{

        public final static String TABELA_NOME = "Habitos";

        public final static String _ID = BaseColumns._ID;

        public final static String COLUNA_HABITO_ACAO = "acao";

        public final static String COLUNA_HABITO_DATA = "data";

    }

}
