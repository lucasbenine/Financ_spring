import Navbar from '../components/Navbar/index';
import styled from 'styled-components';
import HomeImg from '../img/home-img.png';
import logo from '../img/logo.png';
import Footer from '../components/Footer/index';
<<<<<<< HEAD
import { Link } from 'react-router-dom';

const HomeBody = styled.div`
  width: 100%;
  height: 100%;
=======
// import img1 from '../img/financ1.jpeg';
// import img2 from '../img/financ2.jpeg';
// import img3 from '../img/financ3.jpeg';
import { Link } from 'react-router-dom';

const HomeWrapper = styled.div`
  width: 100vw;
  height: 100vh;
>>>>>>> f73d6e29d8b7cf3912c44f10abc1b8b6b7eb7d99
  display: flex;
  align-items: center;
  justify-content: center;

  .img-principal {
    position: absolute;
    left: -3%;
    top: 18%;
    width: 60%;
    height: auto;
  }

  .home-wrapper {
    width: 40%;
    height: 100%;
    display: flex;
    flex-flow: column;
    justify-content: center;
    align-items: center;
    margin-left: 55%;
    margin-top: 10%;
    box-sizing: borderbox;

    img {
      width: 60%;
      height: auto;
      padding: 3%;
    }

    h1 {
      font-weight: 300;
    }

    a {
      width: 45%;

      button {
        width: 100%;
        border: none;
        outline: none;
        padding: 6%;
        font-size: 2rem;
        font-weight: bold;
        background-color: #00DC88;
        transition: .5s;
      }

      button: hover {
        background-color: #00346F;
        color: white;
      }
    }
  }
`;

function Home() {
  return (
    <>
      <Navbar />
      <HomeBody>
        <img className="img-principal" src={HomeImg} alt="Rapaz segurando papéis" />
        <div className="home-wrapper">
          <h1>De aluno para aluno!</h1>
          <img src={logo} alt="Logo finance" />
          <Link to="/cadastro">
            <button>Cadastre-se</button>
          </Link>
        </div>
      </HomeBody>
    </>
  );
}

export default Home;
