package com.divdev.financekeeper.core.persistence.model;

/**
 * @author jlopez
 */
public class OperationTag {
    /**
     * Name of the tag.
     */
    private String tagName;

    /**
     * Description of tag use.
     */
    private String tagDescription;

    /**
     * @return tagName
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * @param tagName the tag name to set
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     * @return tagDescription
     */
    public String getTagDescription() {
        return tagDescription;
    }

    /**
     * @param tagDescription the tag description to set
     */
    public void setTagDescription(String tagDescription) {
        this.tagDescription = tagDescription;
    }
}
