package org.example;

import java.util.*;

public class Main {

    private class Model {
        int capacity;
        int cost;

        public Model(int capacity, int cost) {
            this.capacity = capacity;
            this.cost = cost;
        }
    }

    public int minCost(int[] customers, int[] modelCapacities, int[] modelCosts) {
        int totalCost = 0;
        int hours = customers.length; // 각 시간대별 요청 수
        int modelCount = modelCapacities.length; // 모델의 수

        // 각 시간대에 대해서
        for (int hour = 0; hour < hours; hour++) {
            int requiredCustomers = customers[hour];
            int currentCost = 0;

            // 최소 비용을 찾는 우선순위 큐
            PriorityQueue<Model> modelQueue = new PriorityQueue<>((a, b) -> a.cost - b.cost);

            // 모든 모델을 큐에 추가
            for (int i = 0; i < modelCount; i++) {
                modelQueue.add(new Model(modelCapacities[i], modelCosts[i]));
            }

            // 현재 시간대의 모든 고객을 처리할 때까지 모델을 선택하여 비용을 계산
            while (requiredCustomers > 0) {
                Model bestModel = modelQueue.poll(); // 최소 비용의 모델 선택

                // 모델을 사용하여 처리 가능한 고객 수와 비용 계산
                int handledCustomers = Math.min(requiredCustomers, bestModel.capacity);
                currentCost += bestModel.cost; // 비용은 모델 1개 사용 비용으로 계산

                // 처리한 만큼 고객 수를 줄임
                requiredCustomers -= handledCustomers;
            }

            // 모든 고객을 처리한 후 현재 시간대의 총 비용을 누적
            totalCost += currentCost;
        }

        return totalCost;
    }

    public static void main(String[] args) {

        Main solution = new Main();

        // 테스트 예시
        int[] customers = {10, 20, 5, 15}; // 각 시간대별 상담 요청 수
        int[] modelCapacities = {10, 20}; // 각 모델이 처리할 수 있는 최대 고객 수
        int[] modelCosts = {100, 150}; // 각 모델의 사용 비용

        int minCost = solution.minCost(customers, modelCapacities, modelCosts);
        System.out.println("최소 비용: " + minCost);
    }
}