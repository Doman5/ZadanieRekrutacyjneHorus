package pl.Domanski;

import java.util.List;
import java.util.Optional;

public class Wall implements Structure{
    private List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .filter(block -> block.getColor().equals(color))
                .findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream()
                .filter(block -> block.getMaterial().equals(material))
                .toList();
    }

    int count() {
        return blocks.stream()
                .mapToInt(block -> {
                    if(block instanceof CompositeBlock) {
                        return ((CompositeBlock) block).getBlocks().size();
                    }
                    return 1;
                })
                .sum();
    }
}
