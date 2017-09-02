package com.selkup.prodotiscus.selkupkeyboard;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.media.AudioManager;
import android.view.inputmethod.InputConnection;
import android.view.KeyEvent;
import android.view.View;

/**
 * Created by PRODOTISCUS <f.sizov@yandex.ru>
 */

public class SimpleIME extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    private KeyboardView kv;
    private Keyboard keyboard;

    private boolean caps = false;

    @Override
    public View onCreateInputView() {
        kv = (KeyboardView)getLayoutInflater().inflate(R.layout.keyboard, null);
        keyboard = new Keyboard(this, R.xml.qwerty);
        kv.setKeyboard(keyboard);
        kv.setOnKeyboardActionListener(this);
        return kv;
    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection ic = getCurrentInputConnection();
        playClick(primaryCode);
        switch(primaryCode){
            case Keyboard.KEYCODE_DELETE :
                ic.deleteSurroundingText(1, 0);
                break;
            case Keyboard.KEYCODE_SHIFT:
                caps = !caps;
                keyboard.setShifted(caps);
                kv.invalidateAllKeys();
                break;
            case Keyboard.KEYCODE_DONE:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            default:
                String mc = "";
                switch (primaryCode) {
                    case -800:
                        mc = "й";
                        break;
                    case -801:
                        mc = "ц";
                        break;
                    case -802:
                        mc = "у";
                        break;
                    case -803:
                        mc = "к";
                        break;
                    case -804:
                        mc = "е";
                        break;
                    case -805:
                        mc = "н";
                        break;
                    case -806:
                        mc = "г";
                        break;
                    case -807:
                        mc = "ш";
                        break;
                    case -808:
                        mc = "щ";
                        break;
                    case -809:
                        mc = "з";
                        break;
                    case -810:
                        mc = "х";
                        break;
                    case -811:
                        mc = "ъ";
                        break;
                    case -812:
                        mc = "ф";
                        break;
                    case -813:
                        mc = "ы";
                        break;
                    case -814:
                        mc = "в";
                        break;
                    case -815:
                        mc = "а";
                        break;
                    case -816:
                        mc = "п";
                        break;
                    case -817:
                        mc = "р";
                        break;
                    case -818:
                        mc = "о";
                        break;
                    case -819:
                        mc = "л";
                        break;
                    case -820:
                        mc = "д";
                        break;
                    case -821:
                        mc = "ж";
                        break;
                    case -822:
                        mc = "э";
                        break;
                    case -823:
                        mc = "я";
                        break;
                    case -824:
                        mc = "ч";
                        break;
                    case -825:
                        mc = "с";
                        break;
                    case -826:
                        mc = "м";
                        break;
                    case -827:
                        mc = "и";
                        break;
                    case -828:
                        mc = "т";
                        break;
                    case -829:
                        mc = "ь";
                        break;
                    case -830:
                        mc = "б";
                        break;
                    case -831:
                        mc = "ю";
                        break;
                    case -832:
                        mc = "ҙ";
                        break;
                    case -833:
                        mc = "ӷ";
                        break;
                    case -834:
                        mc = "ӄ";
                        break;
                    case -835:
                        mc = "ӈ";
                        break;
                    case -836:
                        mc = "җ";
                        break;
                    case -837:
                        mc = "ҳ";
                        break;
                    case -838:
                        mc = "ҷ";
                        break;
                    case -839:
                        mc = "̄";
                        break;
                    case -840:
                        mc = "́";
                        break;
                    case -841:
                        mc = "̈";
                        break;
                }
                if (mc != "") {
                    if (caps) {
                        mc = mc.toUpperCase();
                    }
                    ic.commitText(mc, 1);
                }
        }
    }

    @Override
    public void onPress(int primaryCode) {
    }

    @Override
    public void onRelease(int primaryCode) {
    }

    @Override
    public void onText(CharSequence text) {
    }

    @Override
    public void swipeDown() {
    }

    @Override
    public void swipeLeft() {
    }

    @Override
    public void swipeRight() {
    }

    @Override
    public void swipeUp() {
    }

    private void playClick(int keyCode){
        AudioManager am = (AudioManager)getSystemService(AUDIO_SERVICE);
        switch(keyCode){
            case 32:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_SPACEBAR);
                break;
            case Keyboard.KEYCODE_DONE:
            case 10:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_RETURN);
                break;
            case Keyboard.KEYCODE_DELETE:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_DELETE);
                break;
            default: am.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD);
        }
    }
}
