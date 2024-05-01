package com.ohmycar.resolve;

import java.util.Locale;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * <pre>
 *   CustomViewResolver 구현체 Class
 *   UrlBasedViewResolver 에서는 특정 suffix에 매칭되는 URL Pattern이 아니면 Exception을 발생하는 문제가 있음.
 *   다중 View Resolver를 구현하기 위해서 Exception이 아닌 null을 반환하여 p:order값에 따른 여러
 *   ViewResolver를 호출할 수 있도록 Customizing함.
 * </pre>
 *
 */
public class CustomViewResolver extends UrlBasedViewResolver {

    /**
     * <pre>
     * UrlBasedViewResolver의 loadView 를 오버라이딩 함.
     * 기존 loadView에서는 suffix의 확장자에 매칭되는 URL이 없으면 Exception 호출하기 때문에
     * 타 Resolver가 호출되지 않음. 따라서, null을 리턴하도록 수정함.
     *
     * 해당 코딩기법은 e-gov framework Q&A 에서 권고하는 사항을 확인함.
     * </pre>
     *
     */
    @Override
    @SuppressWarnings("null")
    protected View loadView(String viewName, Locale locale) throws Exception {
        AbstractUrlBasedView view = buildView(viewName);
        View viewObj = (View) getApplicationContext().getAutowireCapableBeanFactory().initializeBean(view, viewName);
        if (viewObj instanceof JstlView) {
            JstlView jv = (JstlView) viewObj;
            if (jv.getBeanName().indexOf(".jsp") != -1) {
                return null;
            }
        }
        return viewObj;
    }
}