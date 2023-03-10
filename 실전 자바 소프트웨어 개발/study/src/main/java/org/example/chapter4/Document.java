package org.example.chapter4;

import java.util.Map;

public class Document {
    private final Map<String, String> attributes;

    // 접근제어자를 default로 가져가면서 같은 패키지 내에서만 Document 인스턴스를 생성할 수 있도록 하였다.
    public Document(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getAttribute(final String attributeName) {
        return attributes.get(attributeName);
    }
}
