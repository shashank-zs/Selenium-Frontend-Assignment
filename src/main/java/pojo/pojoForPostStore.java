package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class pojoForPostStore {
    public pojoForPostStore(Object id,Object petId,Object quantity ,Object shipDate ,Object status,Object complete){
        setId(id);
        setPetId(petId);
        setQuantity(quantity);
        setShipDate(shipDate);
        setStatus(status);
        setComplete(complete);

    }
    @JsonProperty("id")
    public Object getId() {
        return this.id; }
    public void setId(Object id) {
        this.id = id; }
    Object id;
    @JsonProperty("petId")
    public Object getPetId() {
        return this.petId; }
    public void setPetId(Object petId) {
        this.petId = petId; }
    Object petId;
    @JsonProperty("quantity")
    public Object getQuantity() {
        return this.quantity; }
    public void setQuantity(Object quantity) {
        this.quantity = quantity; }
    Object quantity;
    @JsonProperty("shipDate")
    public Object getShipDate() {
        return this.shipDate; }
    public void setShipDate(Object shipDate) {
        this.shipDate = shipDate; }
    Object shipDate;
    @JsonProperty("status")
    public Object getStatus() {
        return this.status; }
    public void setStatus(Object status) {
        this.status = status; }
    Object status;
    @JsonProperty("complete")
    public Object getComplete() {
        return this.complete; }
    public void setComplete(Object complete) {
        this.complete = complete; }
    Object complete;
}
