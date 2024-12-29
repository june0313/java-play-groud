// module-info.java 파일은 항상 소스코드 최상단 디렉토리에 위치해야 한다. (보통 src/main/java 디렉토리에 위치)
module member {
    // exports 키워드를 통해 외부로 노출하고자 하는 패키지를 지정한다.
    exports me.jun.module.member.api; // 패키지 경로를 지정
    exports me.jun.module.member.api.model;
}