package org.stepic.java.logging;

/*
Thief – вор, который ворует самые ценные посылки и игнорирует все остальное.
Вор принимает в конструкторе переменную int – минимальную стоимость посылки, которую он будет воровать.
Также, в данном классе должен присутствовать метод getStolenValue, который возвращает суммарную стоимость всех посылок,
которые он своровал. Воровство происходит следующим образом: вместо посылки, которая пришла вору,
он отдает новую, такую же, только с нулевой ценностью и содержимым посылки "stones instead of {content}".
*/

public class Thief implements MailService{
    protected int minPrice;
    protected int StolenValue;

    public Thief(int minPrice){
        this.minPrice = minPrice;
    }

    public int getStolenValue(){
        return StolenValue;
    }

    public Sendable processMail(Sendable mail){
        if (mail instanceof MailPackage){
            if (((MailPackage) mail).getContent().getPrice() > minPrice){
                StolenValue +=((MailPackage) mail).getContent().getPrice();
                return new MailPackage(mail.getFrom(), mail.getTo(),
                        new Package(String.format("stones instead of {0}",
                                ((MailPackage) mail).getContent()),0));
            }
        }
        return mail;
    }
}
