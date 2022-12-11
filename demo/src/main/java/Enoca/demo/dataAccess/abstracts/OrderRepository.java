package Enoca.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Enoca.demo.entities.concretes.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
