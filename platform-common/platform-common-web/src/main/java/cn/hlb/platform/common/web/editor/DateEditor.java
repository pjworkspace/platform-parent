package cn.hlb.platform.common.web.editor;

import cn.hlb.platform.common.utils.DateHelper;

import java.beans.PropertyEditorSupport;

/**
 * @author hlb
 */
public class DateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        setValue(DateHelper.parseDate(text));
    }

}
