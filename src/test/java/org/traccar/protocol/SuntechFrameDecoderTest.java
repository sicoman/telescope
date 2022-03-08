package org.telescope.protocol;

import org.junit.Test;
import org.telescope.ProtocolTest;

public class SuntechFrameDecoderTest extends ProtocolTest {

    @Test
    public void testDecode() throws Exception {

        var decoder = new SuntechFrameDecoder();

        verifyFrame(
                binary("81004e05200013383fffff3401000301130a0512080400000000000000000000000047f9d5846a06810072225214010100020300a8002604c1000004b000000470000025a100000000000025c4000000a6"),
                decoder.decode(null, null, binary("81004e05200013383fffff3401000301130a0512080400000000000000000000000047f9d5846a06810072225214010100020300a8002604c1000004b000000470000025a100000000000025c4000000a6")));

        verifyFrame(
                binary("5354363030414c563b303038373238333237"),
                decoder.decode(null, null, binary("5354363030414c563b3030383732383332370d")));

        verifyFrame(
                binary("53543630305545583b3030383732383332373b32303b3536383b32303139303432343b30383a33333a31313b30626631323833623b3333343b32303b326631393b31383b2b32302e3531343134353b2d3130302e3734333731303b3030302e3030343b3030302e30303b31303b313b31303337373836313b31322e39363b3030303030303b34343b745f303d31333b4e5f303d303839442e303b745f313d31423b4e5f313d304537342e303b515f443d30420d0a3b42343b3032383439383b342e313b31"),
                decoder.decode(null, null, binary("53543630305545583b3030383732383332373b32303b3536383b32303139303432343b30383a33333a31313b30626631323833623b3333343b32303b326631393b31383b2b32302e3531343134353b2d3130302e3734333731303b3030302e3030343b3030302e30303b31303b313b31303337373836313b31322e39363b3030303030303b34343b745f303d31333b4e5f303d303839442e303b745f313d31423b4e5f313d304537342e303b515f443d30420d0a3b42343b3032383439383b342e313b310d")));

    }

}
