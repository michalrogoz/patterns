package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelBuilder;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelProperties;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelPropertyKey;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.spy.TestSpySocialChannel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCensorTest extends AbstractSocialChanneldDecoratorTest {

    @Test
    public void testCensor(){
        SocialChannelBuilder builder = createTestSpySocialChannelBuilder();

        SocialChannelProperties properties = new SocialChannelProperties().putProperty(SocialChannelPropertyKey.NAME, TestSpySocialChannel.NAME);
        SocialChannel channel = builder.with(new WordCensor("cat")).getDecoratedChannel(properties);

        channel.deliverMessage("this is a message - cat");

        TestSpySocialChannel spyChannel = (TestSpySocialChannel) builder.buildChannel(properties);
        assertEquals("this is a message - ###", spyChannel.lastMessagePublished());

    }

}
