package org.telescope.protocol;

import org.junit.Test;
import org.telescope.ProtocolTest;
import org.telescope.model.Command;

public class KhdProtocolEncoderTest extends ProtocolTest {

    @Test
    public void testEncode() throws Exception {

        var encoder = new KhdProtocolEncoder(null);

        Command command = new Command();
        command.setDeviceId(1);

        command.setType(Command.TYPE_ENGINE_STOP);
        verifyCommand(encoder, command, binary("29293900065981972d5d0d"));

        command.setType(Command.TYPE_POSITION_SINGLE);
        verifyCommand(encoder, command, binary("29293000065981972d540d"));

    }

}
