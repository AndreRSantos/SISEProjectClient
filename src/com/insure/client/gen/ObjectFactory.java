
package com.insure.client.gen;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.insure.client.gen package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CheckIfWorking_QNAME = new QName("http://server.insure.com/", "checkIfWorking");
    private final static QName _CheckIfWorkingResponse_QNAME = new QName("http://server.insure.com/", "checkIfWorkingResponse");
    private final static QName _CreateClaim_QNAME = new QName("http://server.insure.com/", "createClaim");
    private final static QName _CreateClaimResponse_QNAME = new QName("http://server.insure.com/", "createClaimResponse");
    private final static QName _RetrieveClaim_QNAME = new QName("http://server.insure.com/", "retrieveClaim");
    private final static QName _RetrieveClaimResponse_QNAME = new QName("http://server.insure.com/", "retrieveClaimResponse");
    private final static QName _UpdateClaim_QNAME = new QName("http://server.insure.com/", "updateClaim");
    private final static QName _UpdateClaimResponse_QNAME = new QName("http://server.insure.com/", "updateClaimResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.insure.client.gen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckIfWorking }
     * 
     */
    public CheckIfWorking createCheckIfWorking() {
        return new CheckIfWorking();
    }

    /**
     * Create an instance of {@link CheckIfWorkingResponse }
     * 
     */
    public CheckIfWorkingResponse createCheckIfWorkingResponse() {
        return new CheckIfWorkingResponse();
    }

    /**
     * Create an instance of {@link CreateClaim }
     * 
     */
    public CreateClaim createCreateClaim() {
        return new CreateClaim();
    }

    /**
     * Create an instance of {@link CreateClaimResponse }
     * 
     */
    public CreateClaimResponse createCreateClaimResponse() {
        return new CreateClaimResponse();
    }

    /**
     * Create an instance of {@link RetrieveClaim }
     * 
     */
    public RetrieveClaim createRetrieveClaim() {
        return new RetrieveClaim();
    }

    /**
     * Create an instance of {@link RetrieveClaimResponse }
     * 
     */
    public RetrieveClaimResponse createRetrieveClaimResponse() {
        return new RetrieveClaimResponse();
    }

    /**
     * Create an instance of {@link UpdateClaim }
     * 
     */
    public UpdateClaim createUpdateClaim() {
        return new UpdateClaim();
    }

    /**
     * Create an instance of {@link UpdateClaimResponse }
     * 
     */
    public UpdateClaimResponse createUpdateClaimResponse() {
        return new UpdateClaimResponse();
    }

    /**
     * Create an instance of {@link Claim }
     * 
     */
    public Claim createClaim() {
        return new Claim();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckIfWorking }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckIfWorking }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "checkIfWorking")
    public JAXBElement<CheckIfWorking> createCheckIfWorking(CheckIfWorking value) {
        return new JAXBElement<CheckIfWorking>(_CheckIfWorking_QNAME, CheckIfWorking.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckIfWorkingResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckIfWorkingResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "checkIfWorkingResponse")
    public JAXBElement<CheckIfWorkingResponse> createCheckIfWorkingResponse(CheckIfWorkingResponse value) {
        return new JAXBElement<CheckIfWorkingResponse>(_CheckIfWorkingResponse_QNAME, CheckIfWorkingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateClaim }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateClaim }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "createClaim")
    public JAXBElement<CreateClaim> createCreateClaim(CreateClaim value) {
        return new JAXBElement<CreateClaim>(_CreateClaim_QNAME, CreateClaim.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateClaimResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateClaimResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "createClaimResponse")
    public JAXBElement<CreateClaimResponse> createCreateClaimResponse(CreateClaimResponse value) {
        return new JAXBElement<CreateClaimResponse>(_CreateClaimResponse_QNAME, CreateClaimResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveClaim }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RetrieveClaim }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "retrieveClaim")
    public JAXBElement<RetrieveClaim> createRetrieveClaim(RetrieveClaim value) {
        return new JAXBElement<RetrieveClaim>(_RetrieveClaim_QNAME, RetrieveClaim.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveClaimResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RetrieveClaimResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "retrieveClaimResponse")
    public JAXBElement<RetrieveClaimResponse> createRetrieveClaimResponse(RetrieveClaimResponse value) {
        return new JAXBElement<RetrieveClaimResponse>(_RetrieveClaimResponse_QNAME, RetrieveClaimResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateClaim }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateClaim }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "updateClaim")
    public JAXBElement<UpdateClaim> createUpdateClaim(UpdateClaim value) {
        return new JAXBElement<UpdateClaim>(_UpdateClaim_QNAME, UpdateClaim.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateClaimResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateClaimResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "updateClaimResponse")
    public JAXBElement<UpdateClaimResponse> createUpdateClaimResponse(UpdateClaimResponse value) {
        return new JAXBElement<UpdateClaimResponse>(_UpdateClaimResponse_QNAME, UpdateClaimResponse.class, null, value);
    }

}
