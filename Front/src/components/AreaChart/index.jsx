import React, { useState, useEffect } from 'react';
import Chart from 'react-apexcharts';


function AreaChart() {

    const series = [
      {
        name: 'Despesas',
        data: [31, 40, 28, 51, 42, 109, 100, 150, 180, 55, 99, 56],
        color: '#FE6161'
      },
      {
        name: 'Receitas',
        data: [11, 32, 45, 32, 34, 52, 41, 125, 65, 98, 166, 39],
        color: '#00DC88'

      }]

      const options = {
        chart: {
          height: 350,
          type: 'area'
        },
        dataLabels: {
          enabled: false
        },
        stroke: {
          curve: 'smooth'
        },
        xaxis: {
          type: 'text',
          categories: ["Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"]
        },
        title: {
            text: 'Despesas e Receitas anual'
        }
        // tooltip: {
        //   x: {
        //     format: 'dd/MM/yy HH:mm'
        //   },
        // },
      }


  return (
      <Chart 
        options={ options }
        series={ series }
        type="area"
        height="200"
      />
  );
}

export default AreaChart;