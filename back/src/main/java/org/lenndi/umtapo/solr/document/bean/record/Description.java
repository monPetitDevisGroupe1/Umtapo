package org.lenndi.umtapo.solr.document.bean.record;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

/**
 * Description entity.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Description {

    private String mainDescription;
    private List<String> otherDescriptions;
    private String mainPhysicalDescription;
    private String secondaryPhysicalDescription;
    private String format;
    private String associatedMaterial;

    /**
     * Instantiates a new Description.
     */
    public Description() {
        this.otherDescriptions = new ArrayList<>();
    }

    /**
     * Gets main description.
     *
     * @return the main description
     */
    public String getMainDescription() {
        return mainDescription;
    }

    /**
     * Sets main description.
     *
     * @param mainDescription the main description
     */
    public void setMainDescription(String mainDescription) {
        this.mainDescription = mainDescription;
    }

    /**
     * Gets other descriptions.
     *
     * @return the other descriptions
     */
    public List<String> getOtherDescriptions() {
        return otherDescriptions;
    }

    /**
     * Sets other descriptions.
     *
     * @param otherDescriptions the other descriptions
     */
    public void setOtherDescriptions(List<String> otherDescriptions) {
        this.otherDescriptions = otherDescriptions;
    }

    /**
     * Add other description.
     *
     * @param description the description
     */
    public void addOtherDescription(String description) {
        this.otherDescriptions.add(description);
    }

    /**
     * Gets main physical description.
     *
     * @return the main physical description
     */
    public String getMainPhysicalDescription() {
        return mainPhysicalDescription;
    }

    /**
     * Sets main physical description.
     *
     * @param mainPhysicalDescription the main physical description
     */
    public void setMainPhysicalDescription(String mainPhysicalDescription) {
        this.mainPhysicalDescription = mainPhysicalDescription;
    }

    /**
     * Gets secondary physical description.
     *
     * @return the secondary physical description
     */
    public String getSecondaryPhysicalDescription() {
        return secondaryPhysicalDescription;
    }

    /**
     * Sets secondary physical description.
     *
     * @param secondaryPhysicalDescription the secondary physical description
     */
    public void setSecondaryPhysicalDescription(String secondaryPhysicalDescription) {
        this.secondaryPhysicalDescription = secondaryPhysicalDescription;
    }

    /**
     * Gets format.
     *
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets format.
     *
     * @param format the format
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Gets associated material.
     *
     * @return the associated material
     */
    public String getAssociatedMaterial() {
        return associatedMaterial;
    }

    /**
     * Sets associated material.
     *
     * @param associatedMaterial the associated material
     */
    public void setAssociatedMaterial(String associatedMaterial) {
        this.associatedMaterial = associatedMaterial;
    }
}
