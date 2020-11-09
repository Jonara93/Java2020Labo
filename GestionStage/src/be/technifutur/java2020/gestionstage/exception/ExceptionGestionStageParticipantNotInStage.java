package be.technifutur.java2020.gestionstage.exception;

public class ExceptionGestionStageParticipantNotInStage extends ExceptionGestionStage {
    public ExceptionGestionStageParticipantNotInStage() {
        super();
    }

    public ExceptionGestionStageParticipantNotInStage(String message) {
        super(message);
    }

    public ExceptionGestionStageParticipantNotInStage(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionGestionStageParticipantNotInStage(Throwable cause) {
        super(cause);
    }

    protected ExceptionGestionStageParticipantNotInStage(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
