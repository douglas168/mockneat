package net.andreinc.mockneat.unit.hashes;

import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.interfaces.MockUnitString;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.function.Supplier;

/**
 * Created by andreinicolinciobanu on 25/03/17.
 */
public class MD2s implements MockUnitString {
    private MockNeat mock;

    public MD2s(MockNeat mock) {
        this.mock = mock;
    }

    @Override
    public Supplier<String> supplier() {
        return mock.strings().size(32).map(DigestUtils::md2Hex).supplier();
    }
}
