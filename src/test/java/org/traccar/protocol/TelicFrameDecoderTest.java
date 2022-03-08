package org.telescope.protocol;

import org.junit.Test;
import org.telescope.ProtocolTest;

public class TelicFrameDecoderTest extends ProtocolTest {

    @Test
    public void testDecode() throws Exception {

        var decoder = new TelicFrameDecoder();

        verifyFrame(
                binary("303032363230333339337c3232367c31307c303032303034303130"),
                decoder.decode(null, null, binary("303032363230333339337c3232367c31307c30303230303430313000")));

        verifyFrame(
                binary("3030333032303333393332352c3139303331373038333035322c302c3138303331373130333132372c3235393932342c3434353133332c332c302c302c392c2c2c39332c31323231303134312c2c303031302c30302c34302c3234302c302c30343036"),
                decoder.decode(null, null, binary("630000003030333032303333393332352c3139303331373038333035322c302c3138303331373130333132372c3235393932342c3434353133332c332c302c302c392c2c2c39332c31323231303134312c2c303031302c30302c34302c3234302c302c3034303600")));

        verifyFrame(
                binary("303032363239363231385343434530315f534343457c3232367c31307c30323637"),
                decoder.decode(null, null, binary("303032363239363231385343434530315f534343457c3232367c31307c3032363700")));

        verifyFrame(
                binary("30303434323936323138544c4f43303236372c30302c3031313030393030303239363231382c3139303331373038333033362c3235353137382c3434353037322c332c302c38322c2c2c2c3136382c31343734313239362c2c30302c30302c302c323137"),
                decoder.decode(null, null, binary("6400000030303434323936323138544c4f43303236372c30302c3031313030393030303239363231382c3139303331373038333033362c3235353137382c3434353037322c332c302c38322c2c2c2c3136382c31343734313239362c2c30302c30302c302c32313700")));

        verifyNull(
                decoder.decode(null, null, binary("00303032363937393238317c3233327c30337c30303230303430313000")));

        verifyFrame(
                binary("303032363937393238317c3233327c30337c303032303034303130"),
                decoder.decode(null, null, binary("303032363937393238317c3233327c30337c30303230303430313000")));

        verifyFrame(
                binary("3030323039373932383139392c3231303231363038313930302c302c3231303231363038313835392c3031333839333338352c34363635383639352c332c302c302c382c2c2c3534312c36313239382c2c303030302c30302c302c3139362c302c30343037"),
                decoder.decode(null, null, binary("650000003030323039373932383139392c3231303231363038313930302c302c3231303231363038313835392c3031333839333338352c34363635383639352c332c302c302c382c2c2c3534312c36313239382c2c303030302c30302c302c3139362c302c3034303700")));

    }

}
