package com.example.dbmsSpring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Stock database table.
 * 
 */
@Entity
//@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="stockSymbol")
	private String stockSymbol;


	@Column(name="stockPrice")
	private String stockPrice;

	@Column(name="marketName")
	private String marketName;



	@Column(name="stockIndustry")
	private String stockIndustry;



	//bi-directional many-to-one association to Bank
	@OneToMany(mappedBy="stock")
	@JsonIgnore
	private List<StockTrade> stockTrades;

	public Stock() {
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public String getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(String stockPrice) {
		this.stockPrice = stockPrice;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getStockIndustry() {
		return stockIndustry;
	}

	public void setStockIndustry(String stockIndustry) {
		this.stockIndustry = stockIndustry;
	}

	public List<StockTrade> getStockTrades() {
		return stockTrades;
	}

	public void setStockTrades(List<StockTrade> stockTrades) {
		this.stockTrades = stockTrades;
	}
}