package org.telescope.protocol;

import org.junit.Test;
import org.telescope.ProtocolTest;

public class DolphinProtocolDecoderTest extends ProtocolTest {

    @Test
    public void testDecode() throws Exception {

        var decoder = new DolphinProtocolDecoder(null);

        verifyPositions(decoder, binary(
                "ababff8f0300000100000100e03c0b86c70e03005c0f0000ab4cd12d0aa9010d0d7f0e4215f6fe6c421d00b0ce4420122daa9a9042359a99f9413806455e53fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa0662404801010ce41bb8f4cc2ad801fe98f3030893dd9a010001019299f303155400000007b401000000000072ac01b99401f8de8a0adc03900e0049000003004bfa010aa7010d4f7f0e421505ff6c421dcd1cce4420112d3ef984423552b89e413806456053fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa06623e4201010ce41bd8f4cc2a20ff98f3030193dd9a010001019399f30315420000000000000000000072ad018f950181df8a0aee03cd0d004b000003004bfa010aa7010da67f0e42154fff6c421d3393cd4420112d073c9942358fc2df413806456253fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa06623e4c010111f51d88f5cc2a308199f3030293dd9a010001019599f303154c0000000000000000000072ad01ef95018bdf8a0aee03d30d004a000003004bfa010aa9010dfd800e421525006d421d3373d04420102da5b7aa4235ec51c4413806456853fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa0662405501010ef01db0f6cc2aa8018899f3030793dd9a010001019c99f3031555000000068a010000000000739d01df9501acdf8a0ac0028a150031000003004bfa010aa8010d3b830e421561016d421dcddcd04420102d8edda94235cdccbe413806457353fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa06623f5401010ef01db8f8cc2a88029499f3030c93dd9a01000101a899f303155500000004480000000000728a018f9501e5df8a0aa9018d280015000003004bfa010aa8010ddd850e4215b3026d421dcd3cd04420112d2e9ba942359a99af413806458053fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa06623f5401010df01df0facc2ab802a199f3030d93dd9a01000101b599f303155500000005760000000000728b01f59401a2e08a0a9b01c12b0018000003004bfa010aa9010d4a870e421554036d421d66d6cf4420112d5f29a842355c8faa413806458753fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa0662405401010dea1d98fccc2aa801a899f3030793dd9a01000101bc99f303155400000007a4010000000000719701b29401bae08a0a9202be180026000003004bfa010aa7010da7870e421591036d421d33d3cf4420112d6329a942353333a7413806458953fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa06623e5401010df51dc8fccc2a30aa99f3030293dd9a01000101be99f3031554000000022c0000000000719901db9401c3e08a0aae02a016002b000003004bfa010aa7010d1a880e4215b6036d421d33e3cf4420112ddc45aa423514aea3413806458b53fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa06623e5501010df51df8fccc2a30ac99f3030293dd9a01000101c099f303155500000002320000000000719e01f69401d1e08a0a9f02b3170031000003004bfa010aa8010d50890e42154d046d421d3363d04420102da0b7a94235d7a3a2413806459253fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa06623f5401010edf1d88fecc2a9001b399f3030793dd9a01000101c799f303155400000000000000000000729a01e69501f7e08a0ab0028e16002d000003004bfa010aa9010d188c0e421573056d421d00c0ce4420102d300c84423514ae7741380645a053fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa06624042010110da1dd080cd2ac802c199f3030e93dd9a01000101d599f303155500000009e2010000000000729801b19501afe18a0a97029018002a000003004bfa010aa7010d528c0e42159d056d421d3313cf4420102dfec98c423552b8c241380645a053fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa06623e46010110da1df080cd2a20c299f3030193dd9a01000101d699f303154600000000000000000000729701df9501b8e18a0aa002b9170029000003004bfa010aa9010d198f0e42159e066d421d9a49d04420112dfae6a642359a999941380645ad53fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa06624053010111e51da883cd2ab802cf99f3030d93dd9a01000101e399f30315540000000ca4020000000000729601c49501f1e18a0a9102dc180028000003004bfa010aa7010da68f0e4215e9066d421d9a19d044200f2d83dda74235ec519441380645b153fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa06623e53010111e51df083cd2a48d299f3030393dd9a01000101e699f303155300000003400000000000729701de950183e28a0a8e02ff180028000003004bfa010aa7010d40900e42151a076d421d33c3cf4420102d717e9b423548e15e41380645b453fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa06623e4d010110e51db884cd2a48d599f3030393dd9a01000101e999f303154d00000003420000000000729801bf950191e28a0a9a02f117002a000003004bfa010aa7010d5f900e42153c076d421d66c6cf44200f2de3028d4235713daa41380645b553fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa06623e46010110da1dc884cd2a10d699f3030193dd9a01000101ea99f303154600000001120000000000729901bf950191e28a0a98029318002b000003004bfa010aa7010dae900e42153d076d421d9ad9cf44200f2d324fa342357b144241380645b653fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa06623e51010110da1de884cd2a20d799f3030193dd9a01000101eb99f303155100000000000000000000729b01a5950196e28a0aa2029b17002c000003004bfa010aa7010d08910e42157e076d421d33b3cf4420102d51b79a42357b14b241380645b853fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa06623e4d010110da1d9885cd2a30d999f3030293dd9a01000101ed99f3031552000000022c0000000000729b01ca95019be28a0ab602e815002f000003004bfa010aa9010d3b930e42153f086d421d9a99d044200f2d5a3ca9423552b88441380645c153fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa06624054010110f51d9087cd2af801e499f3030b93dd9a01000101f899f30315540000000bfa010000000000729901cf9501cee28a0ac502f814002e000003004bfa010aa9010df1950e421558096d421d6646d24420102da3a4a842357b149441380645cf53fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa0662405401010eea1dc889cd2ab802f199f3030d93dd9a01000101859af303155500000008be010000000000729901c7950190e38a0a9c02da17002c000003004bfa010aa9010dcf970e4215260a6d421d6676d34420112d653cab423552b89e41380645d853fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa0662405501010efa1ba08bcd2ad801fa99f3030993dd9a010001018e9af303155600000007a8010000000000729e01bb9501bae38a0ac00284150031000003004bfa010aa8010de89a0e4215510b6d421d00a0d44420112d1aaea74235cdcc6841380645e653fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa06623f53010110f51d808ecd2ae002899af3030f93dd9a010001019d9af30315550000000460000000000073a401e59501fce38a0a9003e510003e000003004bfa010aa9010d6b9c0e4215b00b6d421d00b0d44420112dd46bac423585eb0541380645ed53fc5f48015a41050a0b1e29323334353637464850649601a401a601aa01ab01ad01b401b501b601b701b801c905ca05cb05cd05d105d205e605e705ef059c069e06a206a906aa06624056010110ea1da88fcd2aa801919af3030893dd9a01000101a59af303155600000008a801000000000073a201a19501a1e48a0a8103ce110038000003004bfa01"));

    }

}
