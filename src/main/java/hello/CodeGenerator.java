package hello;

import org.apache.commons.text.RandomStringGenerator;

class CodeGenerator {
    private RandomStringGenerator randomStringGenerator;

    public CodeGenerator() {
        this.randomStringGenerator = new RandomStringGenerator
                .Builder().filteredBy(c -> isLatinLetterOrDigit(c))
                .build();
    }

    public String generate() {
        return randomStringGenerator.generate(6);
    }

    private static boolean isLatinLetterOrDigit(int codePoint) {
        return ('a' <= codePoint && codePoint <= 'z')
                || ('A' <= codePoint && codePoint <= 'Z')
                || ('0' <= codePoint && codePoint <= '9')
                || ('+' == codePoint)
                || ('_' == codePoint)
                || ('-' == codePoint);

    }

}
