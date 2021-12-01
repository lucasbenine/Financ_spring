import Chart from 'react-apexcharts';
import React, { useEffect, useState } from 'react';
import api from '../../api';
import { DespesaSoma } from '../../types/despesa';
import token from '../../token';

type ChartData = {
    labels: string[];
    series: number[];
}


const DonutChart = () => {


    const [chartData, setChartData] = useState<ChartData>({ labels: [], series: []});

    useEffect( () => {

        async function despesaByCategoria() {

            // const token = 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmZXJuYW5kbyIsImV4cCI6MTYzNzQxNjE3Mn0.b0wQ6buxzyu35IM6du-wjp1VLQfIgBSpD2h1dalKi03I_R2i2ykUPPjIOuTB9ZmRy5tJsukagN7ApZZBDesasQ';

            const config = {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            };
            
            await api.get('despesas/amount-by-categoria', config)
                .then((response: { data: DespesaSoma[]; }) => {
                const data = response.data as DespesaSoma[];
                const myLabels = data.map(x => x.categoriaNome);
                const mySeries = data.map(x => x.soma);

                setChartData({ labels: myLabels, series: mySeries})
            });
        
        }

        despesaByCategoria();

    }, []);

    const options = {
        legend: {
            show: true
        }
    }

    return (

        <Chart style={{zIndex:1}}
        options={{ ...options, labels: chartData.labels}}
        series={chartData.series}
        type="donut"
        height="200"
    />

    );
}

export default DonutChart;