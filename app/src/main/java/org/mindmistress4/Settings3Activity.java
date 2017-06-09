package org.mindmistress4;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import bitsAndBytes.wishes.WishTypesCreator;
import filesReadAndWrite.Settings;

public class Settings3Activity extends AppCompatActivity {
    Context mmAppContext = null;

    CheckBox check_halsband         = null;
    CheckBox check_handschellen     = null;
    CheckBox check_fussfessel       = null;
    CheckBox check_handfessel       = null;
    CheckBox check_handtofoot       = null;
    CheckBox check_toes             = null;
    CheckBox check_tumbcuff         = null;
    CheckBox check_kaefig           = null;
    CheckBox check_handschuhe       = null;
    CheckBox check_kniegehen        = null;
    CheckBox check_knebel           = null;
    CheckBox check_brustklemmen     = null;
    CheckBox check_indieeckestellen = null;
    CheckBox check_gewichte         = null;
    CheckBox check_keusch           = null;
    CheckBox check_plug             = null;
    CheckBox check_maske            = null;
    CheckBox check_tv               = null;
    CheckBox check_adore            = null;
    CheckBox check_gerte            = null;


    private void initCheckbutton1() {
        check_halsband         = (CheckBox) findViewById(R.id.checkboxhalsband);
        check_handschellen     = (CheckBox) findViewById(R.id.checkboxhandschellen);
        check_fussfessel       = (CheckBox) findViewById(R.id.checkboxfussfessel);
        check_handfessel       = (CheckBox) findViewById(R.id.checkboxhandfessel);
        check_handtofoot       = (CheckBox) findViewById(R.id.checkboxhandtofoot);
        check_toes             = (CheckBox) findViewById(R.id.checkboxtoes);
        check_tumbcuff         = (CheckBox) findViewById(R.id.checkboxtumbcuff);
        check_kaefig           = (CheckBox) findViewById(R.id.checkboxkaefig);
        check_handschuhe       = (CheckBox) findViewById(R.id.checkboxhandschuhe);
        check_kniegehen        = (CheckBox) findViewById(R.id.checkboxkniegehen);
        check_knebel           = (CheckBox) findViewById(R.id.checkboxknebel);
        check_brustklemmen     = (CheckBox) findViewById(R.id.checkboxbrustklemmen);
        check_indieeckestellen = (CheckBox) findViewById(R.id.checkboxindieeckestellen);
        check_gewichte         = (CheckBox) findViewById(R.id.checkboxgewichte);
        check_keusch           = (CheckBox) findViewById(R.id.checkboxkeusch);
        check_plug             = (CheckBox) findViewById(R.id.checkboxplug);
        check_maske            = (CheckBox) findViewById(R.id.checkboxmaske);
        check_tv               = (CheckBox) findViewById(R.id.checkboxtv);
        check_adore            = (CheckBox) findViewById(R.id.checkboxadore);
        check_gerte            = (CheckBox) findViewById(R.id.checkboxgerte);

        // http://stackoverflow.com/questions/8985468/no-gravity-for-scrollview-how-to-make-content-inside-scrollview-as-center
    }

    private void initCheckbutton2() {
        Settings.getInstance().loadSettings(this.getApplicationContext());
        Settings.getInstance().saveSettings(this.getApplicationContext());

        check_halsband.setChecked(Settings.getInstance().getWishSetting(WishTypesCreator.INDEX_WISH_COLLAR));
        check_handschellen.setChecked(Settings.getInstance().getWishSetting(WishTypesCreator.INDEX_WISH_HANDFESSELN));
        check_fussfessel.setChecked(Settings.getInstance().getWishSetting(WishTypesCreator.INDEX_WISH_FUSSFESSELN));
        check_handfessel.setChecked(Settings.getInstance().getWishSetting(WishTypesCreator.INDEX_WISH_HANDCUFF));
        check_handtofoot.setChecked(Settings.getInstance().getWishSetting(WishTypesCreator.INDEX_WISH_BIND_FOOT_HAND));
        check_toes.setChecked(Settings.getInstance().getWishSetting(WishTypesCreator.INDEX_WISH_BIG_TOES));
        check_tumbcuff.setChecked(Settings.getInstance().getWishSetting(WishTypesCreator.INDEX_WISH_THUMBS));
        check_kaefig.setChecked(Settings.getInstance().getWishSetting(WishTypesCreator.INDEX_WISH_CAGE));
        check_handschuhe.setChecked(Settings.getInstance().getWishSetting(WishTypesCreator.INDEX_WISH_FETISH_GLOVES));
        check_kniegehen.setChecked(Settings.getInstance().getWishSetting(WishTypesCreator.INDEX_WISH_DOWN_KNEES));
        check_knebel.setChecked(Settings.getInstance().getWishSetting(WishTypesCreator.INDEX_WISH_KNEBEL));
        check_brustklemmen.setChecked(Settings.getInstance().getWishSetting(WishTypesCreator.INDEX_WISH_BRUSTKLAMMERN));
        check_indieeckestellen.setChecked(Settings.getInstance().getWishSetting(WishTypesCreator.INDEX_WISH_GO_CORNER));
        check_gewichte.setChecked(Settings.getInstance().getWishSetting(WishTypesCreator.INDEX_WISH_GEWICHTE));
        check_keusch.setChecked(Settings.getInstance().getWishSetting(WishTypesCreator.INDEX_WISH_KG));
        check_plug.setChecked(Settings.getInstance().getWishSetting(WishTypesCreator.INDEX_WISH_DILDO));
        check_maske.setChecked(Settings.getInstance().getWishSetting(WishTypesCreator.INDEX_WISH_MASKE));
        check_tv.setChecked(Settings.getInstance().getWishSetting(WishTypesCreator.INDEX_WISH_TELEVISION));
        check_adore.setChecked(Settings.getInstance().getWishSetting(WishTypesCreator.INDEX_WISH_ADORE_K_M));
        check_gerte.setChecked(Settings.getInstance().getWishSetting(WishTypesCreator.INDEX_WISH_GERTE));
    }

    private void initCheckbutton3() {
        check_halsband.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("halsband checkbox clicked: " + check_halsband.isChecked());

                if(check_halsband.isChecked()) Settings.getInstance().enableWish(WishTypesCreator.INDEX_WISH_COLLAR);
                else Settings.getInstance().disableWish(WishTypesCreator.INDEX_WISH_COLLAR);

                Settings.getInstance().saveSettings(mmAppContext);
            }
        });

        check_handschellen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("handschellen checkbox clicked: " + check_handschellen.isChecked());

                if(check_handschellen.isChecked()) Settings.getInstance().enableWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);
                else Settings.getInstance().disableWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);

                Settings.getInstance().saveSettings(mmAppContext);
            }
        });

        check_fussfessel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("check_fussfessel checkbox clicked");

                if(check_fussfessel.isChecked()) Settings.getInstance().enableWish(WishTypesCreator.INDEX_WISH_FUSSFESSELN);
                else Settings.getInstance().disableWish(WishTypesCreator.INDEX_WISH_FUSSFESSELN);

                Settings.getInstance().saveSettings(mmAppContext);
            }
        });

        check_handfessel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("check_handfessel checkbox clicked");

                if(check_handfessel.isChecked()) Settings.getInstance().enableWish(WishTypesCreator.INDEX_WISH_HANDCUFF);
                else Settings.getInstance().disableWish(WishTypesCreator.INDEX_WISH_HANDCUFF);

                Settings.getInstance().saveSettings(mmAppContext);
            }
        });

        check_handtofoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("check_handtofoot checkbox clicked");

                if(check_handtofoot.isChecked()) Settings.getInstance().enableWish(WishTypesCreator.INDEX_WISH_BIND_FOOT_HAND);
                else Settings.getInstance().disableWish(WishTypesCreator.INDEX_WISH_BIND_FOOT_HAND);

                Settings.getInstance().saveSettings(mmAppContext);
            }
        });

        check_toes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("check_toes checkbox clicked");

                if(check_toes.isChecked()) Settings.getInstance().enableWish(WishTypesCreator.INDEX_WISH_BIG_TOES);
                else Settings.getInstance().disableWish(WishTypesCreator.INDEX_WISH_BIG_TOES);

                Settings.getInstance().saveSettings(mmAppContext);
            }
        });

        check_tumbcuff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("check_tumbcuff checkbox clicked");

                if(check_tumbcuff.isChecked()) Settings.getInstance().enableWish(WishTypesCreator.INDEX_WISH_THUMBS);
                else Settings.getInstance().disableWish(WishTypesCreator.INDEX_WISH_THUMBS);

                Settings.getInstance().saveSettings(mmAppContext);
            }
        });

        check_kaefig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("check_kaefig checkbox clicked");

                if(check_kaefig.isChecked()) Settings.getInstance().enableWish(WishTypesCreator.INDEX_WISH_CAGE);
                else Settings.getInstance().disableWish(WishTypesCreator.INDEX_WISH_CAGE);

                Settings.getInstance().saveSettings(mmAppContext);
            }
        });

        check_handschuhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("check_handschuhe checkbox clicked");

                if(check_handschuhe.isChecked()) Settings.getInstance().enableWish(WishTypesCreator.INDEX_WISH_FETISH_GLOVES);
                else Settings.getInstance().disableWish(WishTypesCreator.INDEX_WISH_FETISH_GLOVES);

                Settings.getInstance().saveSettings(mmAppContext);
            }
        });

        check_kniegehen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("check_kniegehen checkbox clicked");

                if(check_kniegehen.isChecked()) Settings.getInstance().enableWish(WishTypesCreator.INDEX_WISH_DOWN_KNEES);
                else Settings.getInstance().disableWish(WishTypesCreator.INDEX_WISH_DOWN_KNEES);

                Settings.getInstance().saveSettings(mmAppContext);
            }
        });

        check_knebel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("check_knebel checkbox clicked");

                if(check_knebel.isChecked()) Settings.getInstance().enableWish(WishTypesCreator.INDEX_WISH_KNEBEL);
                else Settings.getInstance().disableWish(WishTypesCreator.INDEX_WISH_KNEBEL);

                Settings.getInstance().saveSettings(mmAppContext);
            }
        });

        check_brustklemmen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("check_brustklemmen checkbox clicked");

                if(check_brustklemmen.isChecked()) Settings.getInstance().enableWish(WishTypesCreator.INDEX_WISH_BRUSTKLAMMERN);
                else Settings.getInstance().disableWish(WishTypesCreator.INDEX_WISH_BRUSTKLAMMERN);

                Settings.getInstance().saveSettings(mmAppContext);
            }
        });

        check_indieeckestellen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("check_indieeckestellen checkbox clicked");

                if(check_indieeckestellen.isChecked()) Settings.getInstance().enableWish(WishTypesCreator.INDEX_WISH_GO_CORNER);
                else Settings.getInstance().disableWish(WishTypesCreator.INDEX_WISH_GO_CORNER);

                Settings.getInstance().saveSettings(mmAppContext);
            }
        });

        check_gewichte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("check_gewichte checkbox clicked");

                if(check_gewichte.isChecked()) Settings.getInstance().enableWish(WishTypesCreator.INDEX_WISH_GEWICHTE);
                else Settings.getInstance().disableWish(WishTypesCreator.INDEX_WISH_GEWICHTE);

                Settings.getInstance().saveSettings(mmAppContext);
            }
        });

        check_keusch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("check_keusch checkbox clicked");

                if(check_keusch.isChecked()) Settings.getInstance().enableWish(WishTypesCreator.INDEX_WISH_KG);
                else Settings.getInstance().disableWish(WishTypesCreator.INDEX_WISH_KG);

                Settings.getInstance().saveSettings(mmAppContext);
            }
        });

        check_plug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("check_plug checkbox clicked");

                if(check_plug.isChecked()) Settings.getInstance().enableWish(WishTypesCreator.INDEX_WISH_DILDO);
                else Settings.getInstance().disableWish(WishTypesCreator.INDEX_WISH_DILDO);

                Settings.getInstance().saveSettings(mmAppContext);
            }
        });

        check_maske.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("check_maske checkbox clicked");

                if(check_maske.isChecked()) Settings.getInstance().enableWish(WishTypesCreator.INDEX_WISH_MASKE);
                else Settings.getInstance().disableWish(WishTypesCreator.INDEX_WISH_MASKE);

                Settings.getInstance().saveSettings(mmAppContext);
            }
        });

        check_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("check_tv checkbox clicked");

                if(check_tv.isChecked()) Settings.getInstance().enableWish(WishTypesCreator.INDEX_WISH_TELEVISION);
                else Settings.getInstance().disableWish(WishTypesCreator.INDEX_WISH_TELEVISION);

                Settings.getInstance().saveSettings(mmAppContext);
            }
        });

        check_adore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("check_adore checkbox clicked");

                if(check_adore.isChecked()) Settings.getInstance().enableWish(WishTypesCreator.INDEX_WISH_ADORE_K_M);
                else Settings.getInstance().disableWish(WishTypesCreator.INDEX_WISH_ADORE_K_M);

                Settings.getInstance().saveSettings(mmAppContext);
            }
        });

        check_gerte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("check_gerte checkbox clicked");

                if(check_gerte.isChecked()) Settings.getInstance().enableWish(WishTypesCreator.INDEX_WISH_GERTE);
                else Settings.getInstance().disableWish(WishTypesCreator.INDEX_WISH_GERTE);

                Settings.getInstance().saveSettings(mmAppContext);
            }
        });
    }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings3);

        mmAppContext = this.getApplicationContext();

        initCheckbutton1();
        initCheckbutton2();
        initCheckbutton3();
    }
}


