package org.stepic.java.logging;

/*
Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения,
если была обнаружена подобная посылка. Если он заметил запрещенную посылку с одним из запрещенных
содержимым ("weapons" и "banned substance"), то он бросает IllegalPackageException.
Если он находит посылку, состоящую из камней (содержит слово "stones"),
то тревога прозвучит в виде StolenPackageException. Оба исключения вы должны объявить самостоятельно в
виде непроверяемых исключений.
*/

import static org.stepic.java.logging.Main.BANNED_SUBSTANCE;
import static org.stepic.java.logging.Main.WEAPONS;

public class Inspector implements MailService{

    public Sendable processMail(Sendable mail){
        if (mail instanceof MailMessage){
            if ((((MailMessage) mail).getMessage().contains(WEAPONS)) ||
                    ( ((MailMessage) mail).getMessage().contains(BANNED_SUBSTANCE))){
                throw new IllegalPackageException("error");
            }
            else if (((MailMessage) mail).getMessage().contains("stones")){
                throw new StolenPackageException("error");
            }
        }
        return mail;
    }
}
