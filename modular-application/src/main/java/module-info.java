// open 키워드 : 이 모듈의 모든 패키지에 대해서 다른 모듈이 Reflection 을 사용할 수 있도록 허용한다.
open module application {
    // requires 키워드로 사용하고자 하는(의존하는) 모듈을 지정한다.

    requires static lombok; // 모듈 이름으로 지정

    // spring
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.web;
    requires spring.core;
    requires spring.beans;

    // internal modules
    requires module_a;
    requires member;
}