package org.telescope.protocol;

import org.junit.Test;
import org.telescope.ProtocolTest;

public class TeltonikaFrameDecoderTest extends ProtocolTest {

    @Test
    public void testDecode() throws Exception {

        var decoder = new TeltonikaFrameDecoder();

        verifyFrame(
                binary("000F313233343536373839303132333435"),
                decoder.decode(null, null, binary("FF000F313233343536373839303132333435")));

        verifyFrame(
                binary("000F313233343536373839303132333435"),
                decoder.decode(null, null, binary("000F313233343536373839303132333435")));

    }

}
