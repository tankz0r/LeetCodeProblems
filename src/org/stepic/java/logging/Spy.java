package org.stepic.java.logging;

/*
Spy – шпион, который логгирует о всей почтовой переписке, которая проходит через его руки.
Объект конструируется от экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях.
Он следит только за объектами класса MailMessage и пишет в логгер следующие сообщения (в выражениях
нужно заменить части в фигурных скобках на значения полей почты):
2.1) Если в качестве отправителя или получателя указан "Austin Powers",
то нужно написать в лог сообщение с уровнем WARN: Detected target mail correspondence: from {from} to {to} "{message}"
2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}
*/


import java.util.logging.Level;
import java.util.logging.Logger;

import static org.stepic.java.logging.Main.AUSTIN_POWERS;

public class Spy implements MailService{
    protected Logger LOGGER;

    public Spy(Logger LOGGER){
        this.LOGGER = LOGGER;
    }

    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailMessage){
            if (mail.getFrom() == AUSTIN_POWERS)
                LOGGER.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                        new Object [] {mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()});
            else
                LOGGER.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                        new Object [] {mail.getFrom(), mail.getTo()});
        }
        return mail;
    }
}
