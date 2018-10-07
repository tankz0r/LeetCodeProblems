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
    protected RealMailService rms;

//    public UntrustworthyMailWorker(MailService [] MSs){
//        this.MSs = MSs;
//    }
// do I need to do this way?

    public UntrustworthyMailWorker(MailService [] MSs){
        this.MSs = new MailService[MSs.length];
        for(int i=0; i < MSs.length; i++) this.MSs[i] = MSs[i];
        rms = new RealMailService();
    }

    @Override
    public Sendable processMail(Sendable mail){
        for (MailService MS:MSs){
            mail = MS.processMail(mail);
        }
        return rms.processMail(mail);
    }


    public RealMailService getRealMailService(){
        return rms;
    }
}
