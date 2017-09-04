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
    private int after_caps = 0;

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
        if (caps) {
            after_caps += 1;
        }
        switch (primaryCode) {
            case 50:
                ic.commitText(!caps ? "й" : "й".toUpperCase(),1);
                break;
            case 51:
                ic.commitText(!caps ? "ц" : "ц".toUpperCase(),1);
                break;
            case 52:
                ic.commitText(!caps ? "у" : "у".toUpperCase(),1);
                break;
            case 53:
                ic.commitText(!caps ? "к" : "к".toUpperCase(),1);
                break;
            case 54:
                ic.commitText(!caps ? "е" : "е".toUpperCase(),1);
                break;
            case 55:
                ic.commitText(!caps ? "н" : "н".toUpperCase(),1);
                break;
            case 56:
                ic.commitText(!caps ? "г" : "г".toUpperCase(),1);
                break;
            case 57:
                ic.commitText(!caps ? "ш" : "ш".toUpperCase(),1);
                break;
            case 58:
                ic.commitText(!caps ? "щ" : "щ".toUpperCase(),1);
                break;
            case 59:
                ic.commitText(!caps ? "з" : "з".toUpperCase(),1);
                break;
            case 60:
                ic.commitText(!caps ? "х" : "х".toUpperCase(),1);
                break;
            case 61:
                ic.commitText(!caps ? "ъ" : "ъ".toUpperCase(),1);
                break;
            case 62:
                ic.commitText(!caps ? "ф" : "ф".toUpperCase(),1);
                break;
            case 63:
                ic.commitText(!caps ? "ы" : "ы".toUpperCase(),1);
                break;
            case 64:
                ic.commitText(!caps ? "в" : "в".toUpperCase(),1);
                break;
            case 65:
                ic.commitText(!caps ? "а" : "а".toUpperCase(),1);
                break;
            case 66:
                ic.commitText(!caps ? "п" : "п".toUpperCase(),1);
                break;
            case 67:
                ic.commitText(!caps ? "р" : "р".toUpperCase(),1);
                break;
            case 68:
                ic.commitText(!caps ? "о" : "о".toUpperCase(),1);
                break;
            case 69:
                ic.commitText(!caps ? "л" : "л".toUpperCase(),1);
                break;
            case 70:
                ic.commitText(!caps ? "д" : "д".toUpperCase(),1);
                break;
            case 71:
                ic.commitText(!caps ? "ж" : "ж".toUpperCase(),1);
                break;
            case 72:
                ic.commitText(!caps ? "э" : "э".toUpperCase(),1);
                break;
            case 73:
                ic.commitText(!caps ? "я" : "я".toUpperCase(),1);
                break;
            case 74:
                ic.commitText(!caps ? "ч" : "ч".toUpperCase(),1);
                break;
            case 75:
                ic.commitText(!caps ? "с" : "с".toUpperCase(),1);
                break;
            case 76:
                ic.commitText(!caps ? "м" : "м".toUpperCase(),1);
                break;
            case 77:
                ic.commitText(!caps ? "и" : "и".toUpperCase(),1);
                break;
            case 78:
                ic.commitText(!caps ? "т" : "т".toUpperCase(),1);
                break;
            case 79:
                ic.commitText(!caps ? "ь" : "ь".toUpperCase(),1);
                break;
            case 80:
                ic.commitText(!caps ? "б" : "б".toUpperCase(),1);
                break;
            case 81:
                ic.commitText(!caps ? "ю" : "ю".toUpperCase(),1);
                break;
            case 82:
                ic.commitText(!caps ? "ҙ" : "ҙ".toUpperCase(),1);
                break;
            case 83:
                ic.commitText(!caps ? "ӷ" : "ӷ".toUpperCase(),1);
                break;
            case 84:
                ic.commitText(!caps ? "ӄ" : "ӄ".toUpperCase(),1);
                break;
            case 85:
                ic.commitText(!caps ? "ӈ" : "ӈ".toUpperCase(),1);
                break;
            case 86:
                ic.commitText(!caps ? "җ" : "җ".toUpperCase(),1);
                break;
            case 87:
                ic.commitText(!caps ? "ҳ" : "ҳ".toUpperCase(),1);
                break;
            case 88:
                ic.commitText(!caps ? "ҷ" : "ҷ".toUpperCase(),1);
                break;
            case 89:
                ic.commitText("̄",1);
                break;
            case 90:
                ic.commitText("́",1);
                break;
            case 91:
                ic.commitText("̈",1);
                break;
            case 108:
                ic.commitText("̇",1);
                break;
            case 92:
                ic.commitText(" ",1);
                break;
            case 94:
                ic.commitText(".",1);
                break;
            case 95:
                ic.commitText(",",1);
                break;
            case 96:
                ic.commitText("1",1);
                break;
            case 97:
                ic.commitText("2",1);
                break;
            case 98:
                ic.commitText("3",1);
                break;
            case 99:
                ic.commitText("4",1);
                break;
            case 100:
                ic.commitText("5",1);
                break;
            case 101:
                ic.commitText("6",1);
                break;
            case 102:
                ic.commitText("7",1);
                break;
            case 103:
                ic.commitText("8",1);
                break;
            case 104:
                ic.commitText("9",1);
                break;
            case 105:
                ic.commitText("0",1);
                break;
            case 106:
                ic.commitText("!",1);
                break;
            case 107:
                ic.commitText("?",1);
                break;
            case 109:
                ic.commitText("-",1);
                break;
            case Keyboard.KEYCODE_SHIFT:
                caps = true;
                keyboard.setShifted(caps);
                kv.invalidateAllKeys();
                after_caps += 1;
                break;
            case Keyboard.KEYCODE_DELETE :
                ic.deleteSurroundingText(1, 0);
                break;            
            case Keyboard.KEYCODE_DONE:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
        }
        if (after_caps > 1) {
            caps = false;
            keyboard.setShifted(caps);
            kv.invalidateAllKeys();
            after_caps = 0;
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
