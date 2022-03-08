package org.telescope.protocol;

import org.junit.Test;
import org.telescope.ProtocolTest;
import org.telescope.model.Command;

public class Gt06ProtocolEncoderTest extends ProtocolTest {

    @Test
    public void testEncode() throws Exception {

        var encoder = new Gt06ProtocolEncoder(null);

        Command command = new Command();
        command.setDeviceId(1);
        command.setType(Command.TYPE_ENGINE_STOP);

        verifyCommand(encoder, command, binary("787812800c0000000052656c61792c312300009dee0d0a"));

    }

}
