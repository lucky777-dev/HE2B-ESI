<Qucs Schematic 0.0.20>
<Properties>
  <View=0,0,1040,800,1,0,0>
  <Grid=10,10,1>
  <DataSet=labo2Rch.dat>
  <DataDisplay=labo2Rch.dpl>
  <OpenDisplay=1>
  <Script=labo2Rch.m>
  <RunScript=0>
  <showFrame=0>
  <FrameText0=Titre>
  <FrameText1=Auteur :>
  <FrameText2=Date :>
  <FrameText3=Version :>
</Properties>
<Symbol>
</Symbol>
<Components>
  <GND * 5 440 310 0 0 0 0>
  <R R1 1 490 130 -26 15 0 0 "1 kOhm" 1 "26.85" 0 "0.0" 0 "0.0" 0 "26.85" 0 "US" 0>
  <.DC DC1 1 80 370 0 63 0 0 "26.85" 0 "0.001" 0 "1 pA" 0 "1 uV" 0 "no" 0 "150" 0 "no" 0 "none" 0 "CroutLU" 0>
  <IProbe AmpereMetre 1 370 130 -26 16 0 0>
  <R R2 1 580 240 15 -26 0 1 "2.2 kOhm" 1 "26.85" 0 "0.0" 0 "0.0" 0 "26.85" 0 "US" 0>
  <VProbe VoltMetreRch 1 870 120 28 -31 0 0>
  <.SW SW1 1 540 370 0 63 0 0 "DC1" 1 "list" 1 "Rch" 1 "-10 V" 0 "10 V" 0 "[1 kOhm; 10 kOhm; 100 kOhm]" 1>
  <R Rch 1 740 240 15 -26 0 1 "Rch" 1 "26.85" 0 "0.0" 0 "0.0" 0 "26.85" 0 "US" 0>
  <Vdc V1 1 310 240 18 -26 0 1 "7 V" 1>
</Components>
<Wires>
  <310 130 310 210 "" 0 0 0 "">
  <310 130 340 130 "" 0 0 0 "">
  <400 130 460 130 "" 0 0 0 "">
  <520 130 580 130 "" 0 0 0 "">
  <310 310 440 310 "" 0 0 0 "">
  <310 270 310 310 "" 0 0 0 "">
  <440 310 580 310 "" 0 0 0 "">
  <580 130 580 210 "" 0 0 0 "">
  <580 270 580 310 "" 0 0 0 "">
  <580 130 740 130 "" 0 0 0 "">
  <740 130 740 180 "" 0 0 0 "">
  <580 310 740 310 "" 0 0 0 "">
  <740 270 740 290 "" 0 0 0 "">
  <740 180 740 210 "" 0 0 0 "">
  <740 180 860 180 "" 0 0 0 "">
  <860 140 860 180 "" 0 0 0 "">
  <740 290 740 310 "" 0 0 0 "">
  <740 290 880 290 "" 0 0 0 "">
  <880 140 880 290 "" 0 0 0 "">
</Wires>
<Diagrams>
</Diagrams>
<Paintings>
</Paintings>
