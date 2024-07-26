# Delivery Cost API

This is a simple delivery-cost-api built with Spring Boot.

## Requirements
- Java 8
- Maven

## Setup
1. Clone the repository:
    git clone <repository-url>
    cd delivery-cost-api

2. Build the application:
	mvn clean install

3. Run the application:
	mvn spring-boot:run

4. The application will be available at http://localhost:8080

	**API Endpoints:
	POST /api/delivery-cost/calculate : calculate the cost of delivery of a parcel based on weight and volume(volume = height * width * length).
	
	**Actuator Endpoints:
	Actuator endpoints will be available at http://localhost:8080/actuator.


## Testing using Postman

To calculate the cost of delivery of a parcel using the API, you need to make a 'POST' request to the '/api/delivery-cost/calculate' endpoint with a JSON payload that includes the weight, height, width, length and voucherCode (if applicable) details of the Parcel. Here's how you can do it using an API client like Postman.

### POST
1. Open Postman.
2. Create a new 'POST' request.
3. Enter the URL: 'http://localhost:8080/api/delivery-cost/calculate'.
4. Set the header:
   - Key: 'Content-Type'
   - Value: 'application/json'
5. In the body tab, select 'raw' and choose 'JSON' from the dropdown.
6. Enter the JSON payload:
     {
       "weight": 5,
       "height": 30,
       "width": 20,
       "length": 15,
       "voucherCode": "MYNT"
     }

7. Click 'Send'.

### NOTE: You can use my exported Postman '/deliverycostapi/src/main/resources/postman/delivery-cost-api.postman_collection.json' to test the calculate delivery cost API endpoints. Just import it into the API client, and you can use the saved example API endpoint requests.

### Example Test Cases
Here are a few example test cases you can use to test different scenarios:

1. Valid Small Parcel.
    JSON payload:
   {
     "weight": 2,
     "height": 10,
     "width": 10,
     "length": 10,
     "voucherCode": "MYNT"
   }

   Expected Response: Should return the calculated cost for a small parcel and apply the voucher discount if valid.

2. Valid Medium Parcel.
    JSON payload:
   {
     "weight": 8,
     "height": 20,
     "width": 20,
     "length": 10,
     "voucherCode": "GFI"
   }

   Expected Response: Should return the calculated cost for a medium parcel.

3. Weight Exceeds Limit.
    JSON payload:
   {
     "weight": 55,
     "height": 30,
     "width": 30,
     "length": 30,
     "voucherCode": ""
   }
   Expected Response: Should return an error message stating that the parcel weight exceeds the limit of 50kg.

4. Invalid Parcel Data.
    JSON payload:
   {
     "weight": -5,
     "height": 10,
     "width": 10,
     "length": 10,
     "voucherCode": "MYNT"
   }

   Expected Response: Should return validation error messages for the invalid weight.

Let me know if you need any further assistance!