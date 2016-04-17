package com.divdev.financekeeper.core.persistence.model;

/**
 * Tags for the FinanceNodeOperation records.
 *
 * @author jlopez
 */
public class OperationTag {
    /**
     * Name of the tag.
     */
    private String id;

    /**
     * Description of tag use.
     */
    private String description;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the tag name to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the tag description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
