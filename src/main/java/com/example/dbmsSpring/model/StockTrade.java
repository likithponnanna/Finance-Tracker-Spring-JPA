package com.example.dbmsSpring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the stock_trades database table.
 * 
 */
@Entity
@Table(name="stock_trades")
//@NamedQuery(name="StockTrade.findAll", query="SELECT s FROM StockTrade s")
public class StockTrade implements Serializable {
	private static final long serialVersionUID = 1L;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getStockTransactionId() {
		return stockTransactionId;
	}

	public void setStockTransactionId(int stockTransactionId) {
		this.stockTransactionId = stockTransactionId;
	}

	public int getNoOfStocks() {
		return noOfStocks;
	}

	public void setNoOfStocks(int noOfStocks) {
		this.noOfStocks = noOfStocks;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Id
	@Column(name="stockTransactionId")
	private int stockTransactionId;

	@Column(name="noOfStocks")
	private int noOfStocks;



//	@Column(name="stockPrice")
//	private int stockPrice;


	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="stockSymbol")
	private Stock stock;

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="transactionDate")
	private Date transactionDate;



	public StockTrade() {
	}



}