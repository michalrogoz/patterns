package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

public class WordCensor extends SocialChannelDecorator {

    private String censoredWord;

    public WordCensor(String censoredWord) {
        this.censoredWord = censoredWord;
    }

    @Override
    public void deliverMessage(String message) {
        String censored = message.replaceAll(censoredWord, "###");
        delegate.deliverMessage(censored);
    }
}
