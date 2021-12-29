import React, { useState, useEffect } from 'react';
import Chart from 'react-apexcharts';
import api from '../../api';


function AreaChart() {

    const [somaDespesas, setSomaDespesas] = useState([]);
    const [somaReceitas, setSomaReceitas] = useState([]);

    useEffect(() => {

      async function getDespesasAnual() {

        await api.get('/despesas/anual')
          .then(response => {
            const data = response.data;
            setSomaDespesas(data);
            console.log("soma das despesas " + data);
          })
      }

      getDespesasAnual();

      resetSoma();

    }, [])

    function resetSoma() {
      for(var i =0; i < somaDespesas.length; i++) {
        if (somaDespesas[i] == null) {
          somaDespesas[i] = 0;
        }
      }
      console.log(somaDespesas)
    }

    const series = [
      {
        name: 'Despesas',
        data: somaDespesas,
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
        height="400"
        style={{boxShadow:'0px 0px 13px -6px rgba(0,0,0,0.64)', padding:'5px '}}
      />
  );
}

export default AreaChart;