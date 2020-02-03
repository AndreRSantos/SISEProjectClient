
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

    private final static QName _Exception_QNAME = new QName("http://server.insure.com/", "Exception");
    private final static QName _AddDocument_QNAME = new QName("http://server.insure.com/", "addDocument");
    private final static QName _AddDocumentResponse_QNAME = new QName("http://server.insure.com/", "addDocumentResponse");
    private final static QName _ClaimToString_QNAME = new QName("http://server.insure.com/", "claimToString");
    private final static QName _ClaimToStringResponse_QNAME = new QName("http://server.insure.com/", "claimToStringResponse");
    private final static QName _CreateClaim_QNAME = new QName("http://server.insure.com/", "createClaim");
    private final static QName _CreateClaimResponse_QNAME = new QName("http://server.insure.com/", "createClaimResponse");
    private final static QName _EditDocument_QNAME = new QName("http://server.insure.com/", "editDocument");
    private final static QName _EditDocumentResponse_QNAME = new QName("http://server.insure.com/", "editDocumentResponse");
    private final static QName _ListDocuments_QNAME = new QName("http://server.insure.com/", "listDocuments");
    private final static QName _ListDocumentsResponse_QNAME = new QName("http://server.insure.com/", "listDocumentsResponse");
    private final static QName _ViewDocument_QNAME = new QName("http://server.insure.com/", "viewDocument");
    private final static QName _ViewDocumentResponse_QNAME = new QName("http://server.insure.com/", "viewDocumentResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.insure.client.gen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link AddDocument }
     * 
     */
    public AddDocument createAddDocument() {
        return new AddDocument();
    }

    /**
     * Create an instance of {@link AddDocumentResponse }
     * 
     */
    public AddDocumentResponse createAddDocumentResponse() {
        return new AddDocumentResponse();
    }

    /**
     * Create an instance of {@link ClaimToString }
     * 
     */
    public ClaimToString createClaimToString() {
        return new ClaimToString();
    }

    /**
     * Create an instance of {@link ClaimToStringResponse }
     * 
     */
    public ClaimToStringResponse createClaimToStringResponse() {
        return new ClaimToStringResponse();
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
     * Create an instance of {@link EditDocument }
     * 
     */
    public EditDocument createEditDocument() {
        return new EditDocument();
    }

    /**
     * Create an instance of {@link EditDocumentResponse }
     * 
     */
    public EditDocumentResponse createEditDocumentResponse() {
        return new EditDocumentResponse();
    }

    /**
     * Create an instance of {@link ListDocuments }
     * 
     */
    public ListDocuments createListDocuments() {
        return new ListDocuments();
    }

    /**
     * Create an instance of {@link ListDocumentsResponse }
     * 
     */
    public ListDocumentsResponse createListDocumentsResponse() {
        return new ListDocumentsResponse();
    }

    /**
     * Create an instance of {@link ViewDocument }
     * 
     */
    public ViewDocument createViewDocument() {
        return new ViewDocument();
    }

    /**
     * Create an instance of {@link ViewDocumentResponse }
     * 
     */
    public ViewDocumentResponse createViewDocumentResponse() {
        return new ViewDocumentResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddDocument }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddDocument }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "addDocument")
    public JAXBElement<AddDocument> createAddDocument(AddDocument value) {
        return new JAXBElement<AddDocument>(_AddDocument_QNAME, AddDocument.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddDocumentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddDocumentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "addDocumentResponse")
    public JAXBElement<AddDocumentResponse> createAddDocumentResponse(AddDocumentResponse value) {
        return new JAXBElement<AddDocumentResponse>(_AddDocumentResponse_QNAME, AddDocumentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClaimToString }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClaimToString }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "claimToString")
    public JAXBElement<ClaimToString> createClaimToString(ClaimToString value) {
        return new JAXBElement<ClaimToString>(_ClaimToString_QNAME, ClaimToString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClaimToStringResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClaimToStringResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "claimToStringResponse")
    public JAXBElement<ClaimToStringResponse> createClaimToStringResponse(ClaimToStringResponse value) {
        return new JAXBElement<ClaimToStringResponse>(_ClaimToStringResponse_QNAME, ClaimToStringResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link EditDocument }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EditDocument }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "editDocument")
    public JAXBElement<EditDocument> createEditDocument(EditDocument value) {
        return new JAXBElement<EditDocument>(_EditDocument_QNAME, EditDocument.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditDocumentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EditDocumentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "editDocumentResponse")
    public JAXBElement<EditDocumentResponse> createEditDocumentResponse(EditDocumentResponse value) {
        return new JAXBElement<EditDocumentResponse>(_EditDocumentResponse_QNAME, EditDocumentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListDocuments }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListDocuments }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "listDocuments")
    public JAXBElement<ListDocuments> createListDocuments(ListDocuments value) {
        return new JAXBElement<ListDocuments>(_ListDocuments_QNAME, ListDocuments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListDocumentsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListDocumentsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "listDocumentsResponse")
    public JAXBElement<ListDocumentsResponse> createListDocumentsResponse(ListDocumentsResponse value) {
        return new JAXBElement<ListDocumentsResponse>(_ListDocumentsResponse_QNAME, ListDocumentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewDocument }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ViewDocument }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "viewDocument")
    public JAXBElement<ViewDocument> createViewDocument(ViewDocument value) {
        return new JAXBElement<ViewDocument>(_ViewDocument_QNAME, ViewDocument.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewDocumentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ViewDocumentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "viewDocumentResponse")
    public JAXBElement<ViewDocumentResponse> createViewDocumentResponse(ViewDocumentResponse value) {
        return new JAXBElement<ViewDocumentResponse>(_ViewDocumentResponse_QNAME, ViewDocumentResponse.class, null, value);
    }

}
