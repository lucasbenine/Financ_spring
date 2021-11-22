import Navbar from '../components/Navbar/index';
import styled from 'styled-components';
import Footer from '../components/Footer/index';
import img1 from '../img/financ1.jpeg';
import img2 from '../img/financ2.jpeg';
import img3 from '../img/financ3.jpeg';
import { Link } from 'react-router-dom';

const HomeBody = styled.div`
  width: 100%;
  height: 100%;
  background-color: white;
  display: flex;
  flex-flow: column wrap;
  align-items: center;
  justify-content: center;
`;

const ImgDiv = styled.div`
  margin-top: 1.5%;
  width: 80%;
  display: flex;
  align-items: center;
  justify-content: space-between;

  .text-1 {
    display: flex;
    flex-flow: column nowrap;
    align-items: center;
    justify-content: space-evenly;
    width: 40%;
    text-align: center;
  }

  .title {
    font-size: 2rem;
    margin-bottom: 1rem;
  }

  .description {
    font-size: 1.4rem;
  }

  .img-home {
    width: 45%;
    height: auto;
  }

  a {
    margin-top: 1rem;
    width: 50%;
    text-decoration: none;
  }

  .button-to-cadastro {
    width: 100%;
    background-color: white;
    color: #04660E;
    padding: .6rem;
    outline: none;
    border: 2px solid #04660E;
    font-size: 1.2rem;
    border-radius: 10px;
    transition: .5s;
  }

  .button-to-cadastro:hover {
    background-color: #04660E;
    color: white;
    border: 2px solid white;
  }
`;

function Home() {
  return (
    <>
      <Navbar />
      <HomeBody>
        <ImgDiv>
        <img className="img-home" src={img1} alt="student1" style={{marginTop: '10%'}}/>
        <div className="text-1">
          <h2 className="title">Controle financeiro eficiente</h2>
          <p className="description">Acreditamos que um controle financeiro pode ser <strong>eficiente</strong> e ao mesmo tempo <strong>simples</strong>. Aqui no FinanC você poderá verificar isso na prática, enquanto equilibra suas contas e melhora substancialmente sua saúde financeira.</p>
        </div>
        </ImgDiv>
        <ImgDiv>
        <div className="text-1">
          <h2 className="title">Trace metas</h2>
          <p className="description">Vamos mais longe quando temos disciplina. Ao controlar suas finanças, você terá a oportunidade de traçar metas mais arrojadas, sejam elas de curto, médio ou longo prazo.</p>
        </div>
        <img className="img-home" src={img2} alt="student2" />
        </ImgDiv>
        <ImgDiv>
        <img className="img-home" src={img3} alt="student3" style={{marginTop: '10%'}}/>
        <div className="text-1">
          <h2 className="title">Impulsione seus sonhos</h2>
          <p className="description">Qual o seu sonho? Uma viagem, um imóvel, abrir seu próprio negócio? Tendo metas estabelecidas, você fica mais perto de realizar seus sonhos.</p>
          <Link to="/cadastro">
            <button className="button-to-cadastro">Cadastre-se</button>
          </Link>
        </div>
        </ImgDiv>
      </HomeBody>
      <Footer />
    </>
  );
}

export default Home;
