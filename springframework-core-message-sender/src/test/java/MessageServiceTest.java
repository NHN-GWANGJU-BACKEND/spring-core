import com.nhnacademy.edu.springframework.messagesender.MessageSendService;
import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.SmsMessageSender;
import com.nhnacademy.edu.springframework.messagesender.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MessageServiceTest {
    MessageSendService mss = new MessageSendService();

    @Test
    void testMessageTest(){
        ReflectionTestUtils.setField(mss,"messageSender",new SmsMessageSender());

        boolean actual = mss.sendMessage(new User("tagkdj1@naver.com","010-4358-0106"),"message");
        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void mockTest(){
        MessageSender messageSender = mock(MessageSender.class);
        MessageSendService mss = new MessageSendService();
        mss.setMessageSender(messageSender);

        String name = "taewon";

        when(mss.sendMessage(name)).thenReturn(false);

        boolean actual = mss.sendMessage(name);

        Assertions.assertThat(actual).isEqualTo(false);
    }

    @InjectMocks
    private MessageSendService messageSendService;

    @Mock
    private MessageSender messageSender;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSetupMock(){
        boolean actual = messageSendService.sendMessage(new User("tagkdj1@naver.com","010-4358-0106"),"message");
        Assertions.assertThat(actual).isEqualTo(false);
    }
}
