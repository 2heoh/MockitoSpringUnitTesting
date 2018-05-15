package ru.uc.unit_testing.business;

import ru.uc.unit_testing.data.SomeDataService;

public class SomeBizImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calcualteSum(int[] data) {

        int sum = 0;
        for(int value : data ) {
            sum += value;
        }

        return sum;

    }

    public int calculateSumViaDataService() {
        int sum = 0;
        int data[] = someDataService.retrieveData();

        for(int value : data ) {
            sum += value;
        }

        return sum;

    }
}
