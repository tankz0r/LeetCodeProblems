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

public class Inspector  implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        if(mail instanceof MailPackage) {
            if (((MailPackage) mail).getContent().getContent().equals(WEAPONS) ||
                    ((MailPackage) mail).getContent().getContent().equals(BANNED_SUBSTANCE))
                throw new IllegalPackageException();
            if (((MailPackage) mail).getContent().getContent().contains("stones"))
                throw new StolenPackageException();
        }
        return mail;
    }

}
