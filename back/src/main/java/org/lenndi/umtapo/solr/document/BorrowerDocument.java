package org.lenndi.umtapo.solr.document;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.Date;

/**
 * Flat Borrower representation.
 */
@SolrDocument(solrCoreName = "borrower")
public class BorrowerDocument {

    public static final String CORE_NAME = "borrower";

    @Id
    private String id;

    @Field
    private String name;

    @Field
    private String comment;

    @Field
    private Date birthday;

    @Field
    private Integer quota;

    @Field
    private Boolean emailOptin;

    @Field
    private String addressId;

    @Field
    private String address1;

    @Field
    private String address2;

    @Field
    private String zip;

    @Field
    private String city;

    @Field
    private String phone;

    @Field
    private String email;

    @Field
    private Integer nbLoans;

    @Field
    private Boolean tooMuchLoans;

    @Field
    private Date olderReturn;

    @Field
    private Date subscriptionStart;

    @Field
    private Date subscriptionEnd;

    @Field
    private Integer libraryId;

    @Field
    private String libraryName;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets comment.
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets comment.
     *
     * @param comment the comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Gets birthday.
     *
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * Sets birthday.
     *
     * @param birthday the birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Gets quota.
     *
     * @return the quota
     */
    public Integer getQuota() {
        return quota;
    }

    /**
     * Sets quota.
     *
     * @param quota the quota
     */
    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    /**
     * Gets email optin.
     *
     * @return the email optin
     */
    public Boolean getEmailOptin() {
        return emailOptin;
    }

    /**
     * Sets email optin.
     *
     * @param emailOptin the email optin
     */
    public void setEmailOptin(Boolean emailOptin) {
        this.emailOptin = emailOptin;
    }

    /**
     * Gets address id.
     *
     * @return the address id
     */
    public String getAddressId() {
        return addressId;
    }

    /**
     * Sets address id.
     *
     * @param addressId the address id
     */
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    /**
     * Gets address 1.
     *
     * @return the address 1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * Sets address 1.
     *
     * @param address1 the address 1
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * Gets address 2.
     *
     * @return the address 2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * Sets address 2.
     *
     * @param address2 the address 2
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * Gets zip.
     *
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets zip.
     *
     * @param zip the zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets nb loans.
     *
     * @return the nb loans
     */
    public Integer getNbLoans() {
        return nbLoans;
    }

    /**
     * Sets nb loans.
     *
     * @param nbLoans the nb loans
     */
    public void setNbLoans(Integer nbLoans) {
        this.nbLoans = nbLoans;
    }

    /**
     * Gets too much loans.
     *
     * @return the too much loans
     */
    public Boolean getTooMuchLoans() {
        return tooMuchLoans;
    }

    /**
     * Sets too much loans.
     *
     * @param hasTooMuchLoans the has too much loans
     */
    public void setTooMuchLoans(Boolean hasTooMuchLoans) {
        this.tooMuchLoans = hasTooMuchLoans;
    }

    /**
     * Sets older return.
     *
     * @param olderReturn the older return
     */
    public void setOlderReturn(Date olderReturn) {
        this.olderReturn = olderReturn;
    }

    /**
     * Gets older return.
     *
     * @return the older return
     */
    public Date getOlderReturn() {
        return this.olderReturn;
    }

    /**
     * Sets subscription start.
     *
     * @param subscriptionStart the subscription start
     */
    public void setSubscriptionStart(Date subscriptionStart) {
        this.subscriptionStart = subscriptionStart;
    }

    /**
     * Gets subscription start.
     *
     * @return the subscription start
     */
    public Date getSubscriptionStart() {
        return subscriptionStart;
    }

    /**
     * Sets subscription end.
     *
     * @param subscriptionEnd the subscription end
     */
    public void setSubscriptionEnd(Date subscriptionEnd) {
        this.subscriptionEnd = subscriptionEnd;
    }

    /**
     * Gets subscription end.
     *
     * @return the subscription end
     */
    public Date getSubscriptionEnd() {
        return subscriptionEnd;
    }

    /**
     * Gets library id.
     *
     * @return the library id
     */
    public Integer getLibraryId() {
        return libraryId;
    }

    /**
     * Sets library id.
     *
     * @param libraryId the library id
     */
    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    /**
     * Gets library name.
     *
     * @return the library name
     */
    public String getLibraryName() {
        return libraryName;
    }

    /**
     * Sets library name.
     *
     * @param libraryName the library name
     */
    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }
}
