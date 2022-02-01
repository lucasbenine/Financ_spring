import React, { useState, useEffect } from 'react';
import Chart from 'react-apexcharts';
import api from '../../api';

const BarChart = () => {

    const [somaReceitas, setSomaReceitas] = useState(0.0);
    const [somaDespesas, setSomaDespesas] = useState(0.0);

    useEffect(() => {

        async function getBalancoMensal() {
            await api.get('/usuarios/balanco-mensal')
                .then(response => {
                    const data = response.data;
                    setSomaDespesas(data.somaDespesas);
                    setSomaReceitas(data.somaReceitas);
                });
        }

        getBalancoMensal();

    }, [])

    const series = [{
        data: [somaReceitas, somaDespesas]
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