/*
 * Copyright (c) 2018 William Barkoff.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package TheWaterOfNewYorkCity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccessPointTest {
    @Test
    void accessPoint() {
        AccessPoint A = new AccessPoint("POINT (-73.94458300007643 40.755726999970044),8641,QU,Free,Spot On Networks,QUEENS BRIDGE - JACOB A. RIIS Settlement House,10-25 41 AVENUE,40.755727,-73.944583,999603.226171,214613.274563,Indoor AP - Community Center - Computer Rm,Free - Up to 25 mbs Wi-Fi Service,Queens,Quensbridge Connected,NYC HOUSING AUTHORITY,05/01/2018 12:00:00 AM +0000,4,Queens,QN68,Queensbridge-Ravenswood-Long Island City,26,11101,401,25,4002500,4433386,4004700100,4746");
        assertEquals(A.toString(), "AccessPoint{SSID='Quensbridge Connected', boro=MANHATTAN, remarks='Free - Up to 25 mbs Wi-Fi Service', provider='Spot On Networks', name='QUEENS BRIDGE - JACOB A. RIIS Settlement House', latitude=40.755727, longitude=-73.944583, address='10-25 41 AVENUE', zipCode=11101}");
        AccessPoint B = new AccessPoint(
                "Quensbridge Connected",
                AccessPoint.Boro.MANHATTAN,
                "Free - Up to 25 mbs Wi-Fi Service",
                8641,
                "Spot On Networks",
                "QUEENS BRIDGE - JACOB A. RIIS Settlement House",
                40.755727,
                -73.944583,
                "10-25 41 AVENUE",
                11101);
        assertEquals(B.toString(), "AccessPoint{SSID='Quensbridge Connected', boro=MANHATTAN, remarks='Free - Up to 25 mbs Wi-Fi Service', provider='Spot On Networks', name='QUEENS BRIDGE - JACOB A. RIIS Settlement House', latitude=40.755727, longitude=-73.944583, address='10-25 41 AVENUE', zipCode=11101}");
        assertEquals(A, B);
    }

    @Test
    void getSSID() {
        AccessPoint A = new AccessPoint("POINT (-73.94458300007643 40.755726999970044),8641,QU,Free,Spot On Networks,QUEENS BRIDGE - JACOB A. RIIS Settlement House,10-25 41 AVENUE,40.755727,-73.944583,999603.226171,214613.274563,Indoor AP - Community Center - Computer Rm,Free - Up to 25 mbs Wi-Fi Service,Queens,Quensbridge Connected,NYC HOUSING AUTHORITY,05/01/2018 12:00:00 AM +0000,4,Queens,QN68,Queensbridge-Ravenswood-Long Island City,26,11101,401,25,4002500,4433386,4004700100,4746");
        assertEquals(A.getSSID(), "Quensbridge Connected");
    }

    @Test
    void getBoro() {
        AccessPoint A = new AccessPoint("POINT (-73.94458300007643 40.755726999970044),8641,QU,Free,Spot On Networks,QUEENS BRIDGE - JACOB A. RIIS Settlement House,10-25 41 AVENUE,40.755727,-73.944583,999603.226171,214613.274563,Indoor AP - Community Center - Computer Rm,Free - Up to 25 mbs Wi-Fi Service,Queens,Quensbridge Connected,NYC HOUSING AUTHORITY,05/01/2018 12:00:00 AM +0000,4,Queens,QN68,Queensbridge-Ravenswood-Long Island City,26,11101,401,25,4002500,4433386,4004700100,4746");
        assertEquals(A.getBoro(), AccessPoint.Boro.MANHATTAN);
    }

    @Test
    void getRemarks() {
        AccessPoint A = new AccessPoint("POINT (-73.94458300007643 40.755726999970044),8641,QU,Free,Spot On Networks,QUEENS BRIDGE - JACOB A. RIIS Settlement House,10-25 41 AVENUE,40.755727,-73.944583,999603.226171,214613.274563,Indoor AP - Community Center - Computer Rm,Free - Up to 25 mbs Wi-Fi Service,Queens,Quensbridge Connected,NYC HOUSING AUTHORITY,05/01/2018 12:00:00 AM +0000,4,Queens,QN68,Queensbridge-Ravenswood-Long Island City,26,11101,401,25,4002500,4433386,4004700100,4746");
        assertEquals(A.getRemarks(), "Free - Up to 25 mbs Wi-Fi Service");
    }

    @Test
    void getId() {
        AccessPoint A = new AccessPoint("POINT (-73.94458300007643 40.755726999970044),8641,QU,Free,Spot On Networks,QUEENS BRIDGE - JACOB A. RIIS Settlement House,10-25 41 AVENUE,40.755727,-73.944583,999603.226171,214613.274563,Indoor AP - Community Center - Computer Rm,Free - Up to 25 mbs Wi-Fi Service,Queens,Quensbridge Connected,NYC HOUSING AUTHORITY,05/01/2018 12:00:00 AM +0000,4,Queens,QN68,Queensbridge-Ravenswood-Long Island City,26,11101,401,25,4002500,4433386,4004700100,4746");
        assertEquals(A.getId(), 8641);
    }

    @Test
    void getProvider() {
        AccessPoint A = new AccessPoint("POINT (-73.94458300007643 40.755726999970044),8641,QU,Free,Spot On Networks,QUEENS BRIDGE - JACOB A. RIIS Settlement House,10-25 41 AVENUE,40.755727,-73.944583,999603.226171,214613.274563,Indoor AP - Community Center - Computer Rm,Free - Up to 25 mbs Wi-Fi Service,Queens,Quensbridge Connected,NYC HOUSING AUTHORITY,05/01/2018 12:00:00 AM +0000,4,Queens,QN68,Queensbridge-Ravenswood-Long Island City,26,11101,401,25,4002500,4433386,4004700100,4746");
        assertEquals(A.getProvider(), "Spot On Networks");
    }

    @Test
    void getName() {
        AccessPoint A = new AccessPoint("POINT (-73.94458300007643 40.755726999970044),8641,QU,Free,Spot On Networks,QUEENS BRIDGE - JACOB A. RIIS Settlement House,10-25 41 AVENUE,40.755727,-73.944583,999603.226171,214613.274563,Indoor AP - Community Center - Computer Rm,Free - Up to 25 mbs Wi-Fi Service,Queens,Quensbridge Connected,NYC HOUSING AUTHORITY,05/01/2018 12:00:00 AM +0000,4,Queens,QN68,Queensbridge-Ravenswood-Long Island City,26,11101,401,25,4002500,4433386,4004700100,4746");
        assertEquals(A.getName(), "QUEENS BRIDGE - JACOB A. RIIS Settlement House");
    }

    @Test
    void getLatitude() {
        AccessPoint A = new AccessPoint("POINT (-73.94458300007643 40.755726999970044),8641,QU,Free,Spot On Networks,QUEENS BRIDGE - JACOB A. RIIS Settlement House,10-25 41 AVENUE,40.755727,-73.944583,999603.226171,214613.274563,Indoor AP - Community Center - Computer Rm,Free - Up to 25 mbs Wi-Fi Service,Queens,Quensbridge Connected,NYC HOUSING AUTHORITY,05/01/2018 12:00:00 AM +0000,4,Queens,QN68,Queensbridge-Ravenswood-Long Island City,26,11101,401,25,4002500,4433386,4004700100,4746");
        assertEquals(A.getLatitude(),40.755727);
    }

    @Test
    void getLongitude() {
        AccessPoint A = new AccessPoint("POINT (-73.94458300007643 40.755726999970044),8641,QU,Free,Spot On Networks,QUEENS BRIDGE - JACOB A. RIIS Settlement House,10-25 41 AVENUE,40.755727,-73.944583,999603.226171,214613.274563,Indoor AP - Community Center - Computer Rm,Free - Up to 25 mbs Wi-Fi Service,Queens,Quensbridge Connected,NYC HOUSING AUTHORITY,05/01/2018 12:00:00 AM +0000,4,Queens,QN68,Queensbridge-Ravenswood-Long Island City,26,11101,401,25,4002500,4433386,4004700100,4746");
        assertEquals(A.getLongitude(), -73.944583);
    }

    @Test
    void getAddress() {
        AccessPoint A = new AccessPoint("POINT (-73.94458300007643 40.755726999970044),8641,QU,Free,Spot On Networks,QUEENS BRIDGE - JACOB A. RIIS Settlement House,10-25 41 AVENUE,40.755727,-73.944583,999603.226171,214613.274563,Indoor AP - Community Center - Computer Rm,Free - Up to 25 mbs Wi-Fi Service,Queens,Quensbridge Connected,NYC HOUSING AUTHORITY,05/01/2018 12:00:00 AM +0000,4,Queens,QN68,Queensbridge-Ravenswood-Long Island City,26,11101,401,25,4002500,4433386,4004700100,4746");
        assertEquals(A.getAddress(), "10-25 41 AVENUE");
    }

    @Test
    void getZipCode() {
        AccessPoint A = new AccessPoint("POINT (-73.94458300007643 40.755726999970044),8641,QU,Free,Spot On Networks,QUEENS BRIDGE - JACOB A. RIIS Settlement House,10-25 41 AVENUE,40.755727,-73.944583,999603.226171,214613.274563,Indoor AP - Community Center - Computer Rm,Free - Up to 25 mbs Wi-Fi Service,Queens,Quensbridge Connected,NYC HOUSING AUTHORITY,05/01/2018 12:00:00 AM +0000,4,Queens,QN68,Queensbridge-Ravenswood-Long Island City,26,11101,401,25,4002500,4433386,4004700100,4746");
        assertEquals(A.getZipCode(), 11101);
    }

    @Test
    void calculateDistance() {
        AccessPoint A = new AccessPoint("POINT (-73.94458300007643 40.755726999970044),8641,QU,Free,Spot On Networks,QUEENS BRIDGE - JACOB A. RIIS Settlement House,10-25 41 AVENUE,40.755727,-73.944583,999603.226171,214613.274563,Indoor AP - Community Center - Computer Rm,Free - Up to 25 mbs Wi-Fi Service,Queens,Quensbridge Connected,NYC HOUSING AUTHORITY,05/01/2018 12:00:00 AM +0000,4,Queens,QN68,Queensbridge-Ravenswood-Long Island City,26,11101,401,25,4002500,4433386,4004700100,4746");
        AccessPoint B = new AccessPoint("POINT (-73.94413100020707 40.755332999617764),8642,QU,Free,Spot On Networks,QUEENS BRIDGE - JACOB A. RIIS Settlement House,10-43 41 AVENUE,40.755333,-73.944131,999728.543834,214469.807003,Indoor AP - Queens Public Library,Free - Up to 25 mbs Wi-Fi Service,Queens,Quensbridge Connected,NYC HOUSING AUTHORITY,05/01/2018 12:00:00 AM +0000,4,Queens,QN68,Queensbridge-Ravenswood-Long Island City,26,11101,401,25,4002500,4433386,4004700100,4747");
        double distance = Math.sqrt(Math.abs(Math.pow(A.getLatitude() - B.getLatitude(), 2)+Math.pow(A.getLongitude() - B.getLongitude(), 2)));
        assertEquals(A.calculateDistance(B), distance);
        assertEquals(B.calculateDistance(A), distance);
        assertEquals(A.calculateDistance(40.755333, -73.944131), distance);
    }


}