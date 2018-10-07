package org.stepic.java.logging;

/*
класс, моделирующий ненадежного работника почты, который вместо того, чтобы передать почтовый объект
непосредственно в сервис почты, последовательно передает этот объект набору третьих лиц, а затем, в конце концов,
передает получившийся объект непосредственно экземпляру RealMailService. У UntrustworthyMailWorker должен быть
конструктор от массива MailService ( результат вызова processMail первого элемента массива передается на вход
processMail второго элемента, и т. д.) и метод getRealMailService, который возвращает ссылку на внутренний
экземпляр RealMailService.
* */

public class UntrustworthyMailWorker implements MailService{
    protected MailService [] MSs;

    public UntrustworthyMailWorker(MailService [] MSs){
        this.MSs = MSs;
    }

    @Override
    public Sendable processMail(Sendable mail){
        Sendable result;
        for (MailService MS:MSs){
            result = MS.processMail(mail);
            mail = result;
        }
        return mail;
    }

    public RealMailService getRealMailService(){
        return new RealMailService();
    }
}
