import React, { useState, useEffect } from 'react';
import Chart from 'react-apexcharts';

const BarChart = () => {


        const series = [{
            data: [1500, 450]
        }]

        const options = {
            chart: {
                type: 'bar',
                height: 350
            },
            plotOptions: {
                bar: {
                    borderRadius: 4,
                    horizontal: true,
                }
            },
            colors: ["#00DC88", "#FE6161"],
            
            dataLabels: {
                enabled: false
            },
            xaxis: {
                categories: ['Receitas', 'Despesas']
            },
            title: {
                text: 'Balanço do mês'
              },
        }
        
        

    return (

        <Chart 
            options={ options }
            series={ series }
            type="bar"
            height="200"
        />
    );
}

export default BarChart;